package com.sample.core.utilities.lang;

import java.util.Collection;
import java.util.Map;

public class CollectionUtilities {

    private CollectionUtilities() {
        throw new UnsupportedOperationException("Utility modules should not be instantiated");
    };

    public static boolean isEmpty(Collection<?> collectionToCheck) {
        return collectionToCheck == null || collectionToCheck.isEmpty();
    }

    public static boolean isEmpty(Map<?, ?> mapToCheck) {
        return mapToCheck == null || mapToCheck.isEmpty();
    }

    public static boolean isNotEmpty(Collection<?> collectionToCheck) {
        return collectionToCheck != null && !collectionToCheck.isEmpty();
    }

    public static boolean isNotEmpty(Map<?, ?> mapToCheck) {
        return mapToCheck != null && !mapToCheck.isEmpty();
    }
    
    public static boolean isNotEmpty(Iterable<?> iteratorToCheck) {
        return iteratorToCheck != null && iteratorToCheck.iterator() != null && iteratorToCheck.iterator().hasNext();
    }
}
