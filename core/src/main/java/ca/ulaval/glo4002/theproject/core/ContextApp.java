package ca.ulaval.glo4002.theproject.core;

public abstract class ContextApp {

    public void apply() {
        registerServices();
        applyData();
    }

    protected abstract void registerServices();

    protected abstract void applyData();

}
