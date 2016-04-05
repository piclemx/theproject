package ca.ulaval.glo4002.theproject.service.shared;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertThat;

public class ServiceLocatorTest {

    @Before
    public void clearServiceLocator() {
        ServiceLocator.reset();
    }

    @Test(expected = NoneExistentServiceException.class)
    public void aService_NotRegistered_CannotBeResolved() {
        ServiceLocator.getInstance().obtain(SampleService.class);
    }

    @Test(expected = ExistentServiceException.class)
    public void aSameService_TryToRegister_CannotBeDone() {
        ServiceLocator.getInstance().addService(SampleService.class, new SampleImplementation());
        ServiceLocator.getInstance().addService(SampleService.class, new SampleImplementation());
    }

    @Test
    public void aService_RegisteredAsSingleton_CanBeResolved() {
        ServiceLocator.getInstance().addService(SampleService.class, new SampleImplementation());

        SampleService implementation = ServiceLocator.getInstance().obtain(SampleService.class);

        assertThat(implementation, instanceOf(SampleImplementation.class));
    }

    private interface SampleService {

    }

    private class SampleImplementation implements SampleService {

    }
}
