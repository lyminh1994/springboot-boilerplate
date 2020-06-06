package vn.com.minhlq.boilerplate.util;


public class CollectionUtil {

    private CollectionUtil() {

    }

    public static <T> T getFirst(Iterable<T> iterable) {
        return IterableUtil.getFirst(iterable);
    }
}
