package com.openhabbo.commons.collections;

import java.util.ArrayList;
import java.util.List;

public class CollectionsUtil {
    public static <T> List<T> createList(T... items) {
        final List<T> newList = new ArrayList<T>();

        for(T item : items) {
            newList.add(item);
        }

        return newList;
    }
}
