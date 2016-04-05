package ca.ulaval.glo4002.theproject.service;

import ca.ulaval.glo4002.theproject.domain.account.Account;
import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCard;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardFactory;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.exception.CreditCardNotFoundException;
import ca.ulaval.glo4002.theproject.domain.request.Request;
import ca.ulaval.glo4002.theproject.domain.request.RequestRepository;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestAmount;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestExpirationDate;
import ca.ulaval.glo4002.theproject.domain.request.value.RequestTerminal;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionFactory;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.exception.RefusedTransactionException;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.Vendor;
import ca.ulaval.glo4002.theproject.domain.vendor.VendorRepository;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.TransactionResponse;
import ca.ulaval.glo4002.theproject.presentation.rest.dto.VendorConfirmation;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionService;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.*;

public class TransactionServiceTest {

    private final TransactionReferenceNumber A_REFERENCE_NUMBER = new TransactionReferenceNumber("132");
    private final RequestCardNumber A_REQUEST_CARD_NUMBER = new RequestCardNumber("123456789");
    private final String A_VENDOR_ID = "M1234";
    private final RequestTerminal A_REQUEST_TERMINAL = new RequestTerminal("T1234");
    private final RequestAmount A_REQUEST_AMOUNT = new RequestAmount(600f);

    private TransactionService transactionService;
    private TransactionFactory aTransactionFactory;
    private TransactionRepository aTransactionRepository;
    private RequestRepository aRequestRepository;
    private CreditCardRepository aCreditCardRepository;
    private CreditCardFactory aCreditCardFactory;
    private AccountRepository anAccountRepository;
    private VendorRepository aVendorRepository;
    private TerminalRepository aTerminalRepository;
    private Transaction aTransaction;
    private Request aRequest;
    private CreditCard aCreditCard;
    private Account anAccount;
    private TransactionResponse aTransactionResponse;
    private Vendor aVendor;

    @Before
    public void init() {
        aTransactionFactory = mock(TransactionFactory.class);
        aTransactionRepository = mock(TransactionRepository.class);
        aRequestRepository = mock(RequestRepository.class);
        aCreditCardRepository = mock(CreditCardRepository.class);
        aCreditCardFactory = mock(CreditCardFactory.class);
        anAccountRepository = mock(AccountRepository.class);
        aVendorRepository = mock(VendorRepository.class);
        aTerminalRepository = mock(TerminalRepository.class);
        aRequest = mock(Request.class);
        aCreditCard = mock(CreditCard.class);
        aTransaction = mock(Transaction.class);
        anAccount = mock(Account.class);
        aVendor = mock(Vendor.class);

        transactionService = new TransactionService(
                aTransactionFactory,
                aTransactionRepository,
                aRequestRepository,
                aCreditCardRepository,
                anAccountRepository,
                aVendorRepository,
                aCreditCardFactory,
                aTerminalRepository);

        willReturn(aTransaction).given(aTransactionFactory).createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);
        willReturn(A_REFERENCE_NUMBER).given(aTransaction).getReferenceNumber();
        willReturn(A_REQUEST_CARD_NUMBER).given(aRequest).getCardNumber();
        willReturn(A_REQUEST_TERMINAL).given(aRequest).getTerminal();
        willReturn(A_REQUEST_AMOUNT).given(aRequest).getAmount();
        willReturn(aCreditCard).given(aCreditCardRepository).findByCardNumber(any());
        willReturn(anAccount).given(anAccountRepository).findByCreditCardNumber(any());
        willReturn(aVendor).given(aVendorRepository).findByTerminal(any());
        willReturn(true).given(aCreditCard).isValid();
        willReturn(aCreditCard).given(aCreditCardFactory).createCreditCard(
                any(RequestCardNumber.class),
                any(RequestExpirationDate.class)
        );
        willReturn(anAccount).given(anAccountRepository).findByCreditCardNumber(any());
    }

    @Test
    public void aConfirmationRequest_confirmTransactions_vendorConfirmsTransactions() {
        VendorConfirmation vendorConfirmation = mock(VendorConfirmation.class);
        Vendor vendor = mock(Vendor.class);
        when(aVendorRepository.findByIdentifier(any())).thenReturn(vendor);

        try {
            transactionService.confirmTransactions(A_VENDOR_ID, vendorConfirmation);
        } catch (RuntimeException neededForSimplicity) {
        }

        verify(vendor).confirmTransactions(any(), any());
    }

    @Test
    public void aValidRequest_Processed_ShouldBeSaved() {
        transactionService.processRequest(aRequest);

        verify(aRequestRepository).persist(aRequest);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequestWithNotExistingCreditCard_Processed_ShouldNotGenerateTransaction() {
        willThrow(new CreditCardNotFoundException()).given(aCreditCardRepository).findByCardNumber(any());

        transactionService.processRequest(aRequest);

        verify(aTransactionFactory, never()).createTransaction(any(), any(), any());
    }

    @Test
    public void aValidRequest_ProcessedAndAuthorized_ShouldGenerateTransaction() {
        transactionService.processRequest(aRequest);

        verify(aTransactionFactory).createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequestWithoutAccountLinked_Processed_ShouldNotSaveTransaction() {
        willThrow(new RefusedTransactionException()).given(aTransactionFactory).createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        transactionService.processRequest(aRequest);

        verify(aTransactionRepository, never()).persist(aTransaction);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequestWithExpiredCreditCard_Processed_ShouldNotSaveTransaction() {
        willThrow(new RefusedTransactionException()).given(aTransactionFactory).createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        transactionService.processRequest(aRequest);

        verify(aTransactionRepository, never()).persist(aTransaction);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequestWithNotEnoughFunds_Processed_ShouldNotSaveTransaction() {
        willThrow(new RefusedTransactionException()).given(anAccount).addTransaction(aTransaction);

        transactionService.processRequest(aRequest);

        verify(aTransactionRepository, never()).persist(aTransaction);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequestWithNotEnoughFunds_Processed_ShouldNotSaveAccount() {
        willThrow(new RefusedTransactionException()).given(anAccount).addTransaction(aTransaction);

        transactionService.processRequest(aRequest);

        verify(anAccountRepository, never()).persist(anAccount);
    }

    @Test
    public void aValidRequest_ProcessedAndAuthorized_ShouldSaveTransaction() {
        transactionService.processRequest(aRequest);

        verify(aTransactionRepository).persist(aTransaction);
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequest_ProcessedWithAccountNotExist_ShouldHaveFalseJudgment() {
        willThrow(new RefusedTransactionException()).given(aTransactionFactory).createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        aTransactionResponse = transactionService.processRequest(aRequest);

        assertFalse(aTransactionResponse.getJudgment());
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequest_ProcessedWithExpirationDateExpired_ShouldHaveFalseJudgment() {
        willThrow(new RefusedTransactionException()).given(aTransactionFactory).createTransaction(A_REQUEST_AMOUNT, aCreditCard, aVendor);

        aTransactionResponse = transactionService.processRequest(aRequest);

        assertFalse(aTransactionResponse.getJudgment());
    }

    @Test(expected = RefusedTransactionException.class)
    public void aValidRequest_ProcessedWithNotEnoughFunds_ShouldHaveFalseJudgment() {
        willThrow(new RefusedTransactionException()).given(anAccount).addTransaction(aTransaction);

        aTransactionResponse = transactionService.processRequest(aRequest);

        assertFalse(aTransactionResponse.getJudgment());
    }

    @Test
    public void aValidRequest_ProcessedAndAuthorized_ShouldHaveATrueJudgment() {
        aTransactionResponse = transactionService.processRequest(aRequest);

        assertTrue(aTransactionResponse.getJudgment());
    }

    @Test
    public void aValidRequest_CreateTransaction_CreatesACreditCard() {
        transactionService.processRequest(aRequest);

        verify(aCreditCardRepository).findByCardNumber(any());
    }

    @Test
    public void aRequest_ProcessRequest_CallsValidateRequest() {
        transactionService.processRequest(aRequest);

        verify(aRequest).validate();
    }
}