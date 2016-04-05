package ca.ulaval.glo4002.theproject.service.shared;

import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;

@SuppressWarnings("unchecked")
public class ServiceLocator {
    private static final ReentrantLock lock = new ReentrantLock();
    private static ServiceLocator instance;
    private HashMap<Class<?>, Object> services;

    private ServiceLocator() {
        services = new HashMap<Class<?>, Object>();
    }

    public static ServiceLocator getInstance() {
        if (instance == null) {
            lock.lock();
            try {
                if (instance == null) {
                    instance = new ServiceLocator();
                }
            } finally {
                lock.unlock();
            }

        }
        return instance;
    }

    public static void reset() {
        lock.lock();
        try {
            instance = null;
        } finally {
            lock.unlock();
        }
    }

    
	public <T> T obtain(Class<T> service) {
        if (!services.containsKey(service)) {
            throw new NoneExistentServiceException(service);
        }
        return (T) services.get(service);
    }

    public <T> void addService(Class<T> service, T implementation) {
        if (services.containsKey(service)) {
            throw new ExistentServiceException(service);
        }

        services.put(service, implementation);
    }

}
