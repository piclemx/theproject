package ca.ulaval.glo4002.theproject.core;

import ca.ulaval.glo4002.theproject.domain.account.AccountFactory;
import ca.ulaval.glo4002.theproject.domain.account.AccountRepository;
import ca.ulaval.glo4002.theproject.domain.account.value.AccountCreditLimit;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardFactory;
import ca.ulaval.glo4002.theproject.domain.creditcard.CreditCardRepository;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardExpirationDate;
import ca.ulaval.glo4002.theproject.domain.creditcard.value.CreditCardNumber;
import ca.ulaval.glo4002.theproject.domain.request.RequestFactory;
import ca.ulaval.glo4002.theproject.domain.request.RequestRepository;
import ca.ulaval.glo4002.theproject.domain.terminal.Terminal;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalFactory;
import ca.ulaval.glo4002.theproject.domain.terminal.TerminalRepository;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionFactory;
import ca.ulaval.glo4002.theproject.domain.transaction.TransactionRepository;
import ca.ulaval.glo4002.theproject.domain.vendor.*;
import ca.ulaval.glo4002.theproject.domain.vendor.value.VendorIdentifier;
import ca.ulaval.glo4002.theproject.persistence.*;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerFactoryProvider;
import ca.ulaval.glo4002.theproject.persistence.entitymanager.EntityManagerProvider;
import ca.ulaval.glo4002.theproject.service.shared.ServiceLocator;
import ca.ulaval.glo4002.theproject.service.transaction.TransactionService;

import java.util.Arrays;
import java.util.Collections;

public class ContextBase extends ContextApp {

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
        AccountRepository accountRepository = ServiceLocator.getInstance().obtain(AccountRepository.class);
        VendorRepository vendorRepository = ServiceLocator.getInstance().obtain(VendorRepository.class);
        AccountFactory accountFactory = ServiceLocator.getInstance().obtain(AccountFactory.class);
        CreditCardFactory creditCardFactory = ServiceLocator.getInstance().obtain(CreditCardFactory.class);

        AccountCreditLimit limit = new AccountCreditLimit(1200);

        CreditCardNumber cardNumber1 = new CreditCardNumber("4916432296478696");
        CreditCardNumber cardNumber2 = new CreditCardNumber("4539536574851");
        CreditCardNumber cardNumber3 = new CreditCardNumber("5562028007350036");

        CreditCardExpirationDate expirationDate = new CreditCardExpirationDate("02/16");

        Terminal terminal1 = new Terminal("T36735353");
        Terminal terminal2 = new Terminal("T37415244");
        Terminal terminal3 = new Terminal("T36353531");

        Vendor vendor1 = new Vendor(Arrays.asList(terminal1, terminal2), Collections.emptyList(), new VendorIdentifier("M47352424"));
        Vendor vendor2 = new Vendor(Arrays.asList(terminal3), Collections.emptyList(), new VendorIdentifier("M83635636"));

        terminal1.setVendor(vendor1);
        terminal2.setVendor(vendor1);
        terminal3.setVendor(vendor2);

        EntityManagerProvider.setEntityManager(EntityManagerFactoryProvider.getFactory().createEntityManager());

        try {
            accountRepository.persist(accountFactory.createAccount(limit, creditCardFactory.createCreditCard(cardNumber1, expirationDate)));
            accountRepository.persist(accountFactory.createAccount(limit, creditCardFactory.createCreditCard(cardNumber2, expirationDate)));
            accountRepository.persist(accountFactory.createAccount(limit, creditCardFactory.createCreditCard(cardNumber3, expirationDate)));

            vendorRepository.persist(vendor1);
            vendorRepository.persist(vendor2);
        } finally {
            EntityManagerProvider.clearEntityManager();
        }
    }
}
