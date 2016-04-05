package ca.ulaval.glo4002.theproject;

import ca.ulaval.glo4002.theproject.core.ContextApp;
import ca.ulaval.glo4002.theproject.domain.account.AccountFactory;
import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardFactory;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.RequestFactory;
import ca.ulaval.glo4002.theproject.domain.request.RequestRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionFactory;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalFactory;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.VendorFactory;
import ca.ulaval.glo4002.theproject.domain.vendor.VendorRepository;
import ca.ulaval.glo4002.theproject.persistence.*;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionService;

public class TestContext extends ContextApp {

    @Override
    protected void registerServices() {
        ServiceLocator.getInstance().addService(AccountFactory.class, new AccountFactory());
        ServiceLocator.getInstance().addService(AccountRepository.class, new HibernateAccountRepository());

        ServiceLocator.getInstance().addService(CreditCardFactory.class, new CreditCardFactory());
        ServiceLocator.getInstance().addService(CreditCardRepository.class, new HibernateCreditCardRepository());

        ServiceLocator.getInstance().addService(RequestFactory.class, new RequestFactory());
        ServiceLocator.getInstance().addService(RequestRepository.class, new HibernateRequestRepository());

        ServiceLocator.getInstance().addService(TransactionFactory.class, new TransactionFactory());
        ServiceLocator.getInstance().addService(TransactionRepository.class, new HibernateTransactionRepository());

        ServiceLocator.getInstance().addService(VendorFactory.class, new VendorFactory());
        ServiceLocator.getInstance().addService(VendorRepository.class, new HibernateVendorRepository());

        ServiceLocator.getInstance().addService(TerminalFactory.class, new TerminalFactory());
        ServiceLocator.getInstance().addService(TerminalRepository.class, new HibernateTerminalRepository());

        ServiceLocator.getInstance().addService(TransactionService.class, new TransactionService());
    }

    @Override
    protected void applyData() {
        AccountFactory accountFactory = ServiceLocator.getInstance().obtain(AccountFactory.class);
        AccountRepository accountRepository = ServiceLocator.getInstance().obtain(AccountRepository.class);
        CreditCardFactory creditCardFactory = ServiceLocator.getInstance().obtain(CreditCardFactory.class);

        AccountCreditLimit limit = new AccountCreditLimit(1200);

        CreditCardNumber cardNumber1 = new CreditCardNumber("4916432296478696");
        CreditCardNumber cardNumber2 = new CreditCardNumber("4539536574851");
        CreditCardNumber cardNumber3 = new CreditCardNumber("5562028007350036");

        CreditCardExpirationDate expirationDate = new CreditCardExpirationDate("02/16");

        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());

        accountRepository.persist(accountFactory.createAccount(limit, creditCardFactory.createCreditCard(cardNumber1, expirationDate)));
        accountRepository.persist(accountFactory.createAccount(limit, creditCardFactory.createCreditCard(cardNumber2, expirationDate)));
        accountRepository.persist(accountFactory.createAccount(limit, creditCardFactory.createCreditCard(cardNumber3, expirationDate)));
    }

    public void reinitialize() {
        ServiceLocator.reset();
        apply();
    }
}
