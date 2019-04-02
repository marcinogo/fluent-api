package ogo.marcin.fluentapi;

import java.util.function.Supplier;

/**
 * @author Marcin Ogorzalek
 */
public class FluentConditionals {
    public static final Runnable doNothing = () -> {};
    private Supplier<Boolean> condition;
    private int number;

    private FluentConditionals(boolean condition) {
        this.condition = () -> condition;
    }

    public static FluentConditionals when(boolean condition) {
        return new FluentConditionals(condition);
    }

    public static FluentConditionals when(Supplier<Boolean> supplierBoolean) {
        return new FluentConditionals(supplierBoolean.get());
    }

    public FluentConditionals then(Runnable runnable) {
        if(condition.get()) runnable.run();
        return this;
    }

    public void orElse(Runnable runnable) {
        if (!condition.get()) runnable.run();
    }

// TODO change back to void
    public int orElseThrowE(RuntimeException exception){
        if (!condition.get()) throw exception;
        return number;
    }

// TODO change back to void
    public int orElseThrow(Supplier<RuntimeException> exceptionSupplier){
        return this.orElseThrowE(exceptionSupplier.get());
    }

    public FluentConditionals thenReturn(Supplier<Integer> supplier) {
        this.number = supplier.get();
        return this;
    }

    public Integer orElse(Integer number) {
        if(condition.get()) return this.number;
        return number;
    }

    public Integer orElse(Supplier<Integer> integerSupplier) {
        return this.orElse(integerSupplier.get());
    }

//    TODO inny sposób na task 4 bez modyfikacji tasku 2

    public static class GenericFluentConditional<ReturnValueType> {
        
    }
}
