package com.sample.core.utilities.lang;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class ReflectionUtilities {

    private ReflectionUtilities() {
        throw new UnsupportedOperationException("Utility modules should not be instantiated");
    }

    public static <T> T instantiate(Class<? extends T> clazz, Object... ctorArgs) {
        Class<?>[] argTypes = new Class<?>[ctorArgs.length];
        T instantiatedObj = null;

        for (int i = 0; i < ctorArgs.length; i++) {
            argTypes[i] = ctorArgs[i].getClass();
        }

        try {
            Constructor<?> instantiableCtor = clazz.getConstructor(argTypes);
            instantiatedObj = clazz.cast(instantiableCtor.newInstance(ctorArgs));

        } catch (NoSuchMethodException e) {
        } catch (IllegalArgumentException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e.getTargetException());
        }

        return instantiatedObj;
    }
}
