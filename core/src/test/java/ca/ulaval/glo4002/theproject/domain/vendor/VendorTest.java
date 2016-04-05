package ca.ulaval.glo4002.theproject.domain.vendor;

import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.transaction.Transaction;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.value.TransactionReferenceNumber;
import ca.ulaval.glo4002.theproject.domain.vendor.exception.VendorImproperTransactionException;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.BDDMockito.verify;
import static org.mockito.BDDMockito.when;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class VendorTest {

    private String A_REFERENCE_NUMBER = "TX1234";

    @Mock
    private VendorIdentifier aVendorIdentifier;

    @Mock
    private Terminal aTerminal;

    private Vendor aVendor;

    @Before
    public void init() {
        aVendor = new Vendor(aVendorIdentifier);
    }

    @Test
    public void aVendorWithoutGoodTransaction_confirmTransaction_returnFalse() {
        Transaction notHisTransaction = mock(Transaction.class);
        when(notHisTransaction.hasVendor(aVendor)).thenReturn(false);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(notHisTransaction);

        boolean canConfirm = aVendor.canConfirmTransactions(transactions);

        assertFalse(canConfirm);
    }

    @Test
    public void aVendorWithoutGoodTransaction_getBadTransactions_returnBadTransactions() {
        Transaction notHisTransaction = mock(Transaction.class);
        when(notHisTransaction.hasVendor(aVendor)).thenReturn(false);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(notHisTransaction);

        List<Transaction> badTransactions = aVendor.getBadTransactions(transactions);

        assertFalse(badTransactions.isEmpty());
    }

    @Test
    public void aVendor_addTerminal_containsTerminal() {
        Terminal terminal = mock(Terminal.class);

        aVendor.addTerminal(terminal);

        assertFalse(aVendor.getTerminals().isEmpty());
    }

    @Test
    public void aVendor_addTransaction_containsTransaction() {
        Transaction transaction = mock(Transaction.class);

        aVendor.addTransaction(transaction);

        assertFalse(aVendor.getTransactions().isEmpty());
    }

    @Test
    public void aVendorWithItself_equals_shouldCallIdentifier() {
        aVendor.equals(aVendor);

        verify(aVendorIdentifier).equals(aVendorIdentifier);
    }

    @Test
    public void aVendorWithTransactions_confirmTransactions_callsChangeStatusOnTxRepo() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        doNothing().when(transactionRepository).changeStatus(any(), any());
        this.addGoodTransactionToVendor(aVendor);
        List<Transaction> transactions = aVendor.getTransactions();

        aVendor.confirmTransactions(transactionRepository, transactions);

        verify(transactionRepository).changeStatus(any(), any());
    }

    @Test(expected = VendorImproperTransactionException.class)
    public void aVendorWithBadTransactions_confirmTransactions_doesntCallChangeStatusTxRepo() {
        TransactionRepository transactionRepository = mock(TransactionRepository.class);
        doNothing().when(transactionRepository).changeStatus(any(), any());
        this.addBadTransactionToVendor(aVendor);
        List<Transaction> transactions = aVendor.getTransactions();

        aVendor.confirmTransactions(transactionRepository, transactions);

        verifyZeroInteractions(transactionRepository);
    }

    private void addGoodTransactionToVendor(Vendor vendor) {
        Transaction aTransaction = mock(Transaction.class);
        when(aTransaction.hasVendor(vendor)).thenReturn(true);
        vendor.addTransaction(aTransaction);
    }

    private void addBadTransactionToVendor(Vendor vendor) {
        TransactionReferenceNumber referenceNumber = new TransactionReferenceNumber(A_REFERENCE_NUMBER);
        Transaction aTransaction = mock(Transaction.class);
        when(aTransaction.getReferenceNumber()).thenReturn(referenceNumber);
        when(aTransaction.hasVendor(vendor)).thenReturn(false);
        vendor.addTransaction(aTransaction);
    }


}
