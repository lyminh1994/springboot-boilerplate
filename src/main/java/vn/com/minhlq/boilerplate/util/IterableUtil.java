package vn.com.minhlq.boilerplate.util;

import org.apache.commons.collections4.IterableUtils;

import java.util.Iterator;

public class IterableUtil extends IterableUtils {

    public static <T> T getFirst(Iterator<T> iterator) {
        return null != iterator && iterator.hasNext() ? iterator.next() : null;
    }

    public static <T> T getFirst(Iterable<T> iterable) {
        return null == iterable ? null : getFirst(iterable.iterator());
    }
}
