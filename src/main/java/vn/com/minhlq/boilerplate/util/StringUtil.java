package vn.com.minhlq.boilerplate.util;

/**
 * <p>
 * String General Tools
 * </p>
 */
public class StringUtil {

    private StringUtil() {}

    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    public static String toString(CharSequence cs) {
        return cs == null ? null : cs.toString();
    }

    public static String replace(CharSequence str, int startInclude, int endExclude, char replacedChar) {
        if (isEmpty(str)) {
            return toString(str);
        } else {
            int strLength = str.length();
            if (startInclude > strLength) {
                return toString(str);
            } else {
                if (endExclude > strLength) {
                    endExclude = strLength;
                }

                if (startInclude > endExclude) {
                    return toString(str);
                } else {
                    char[] chars = new char[strLength];

                    for(int i = 0; i < strLength; ++i) {
                        if (i >= startInclude && i < endExclude) {
                            chars[i] = replacedChar;
                        } else {
                            chars[i] = str.charAt(i);
                        }
                    }

                    return new String(chars);
                }
            }
        }
    }

    public static String hide(CharSequence str, int startInclude, int endExclude) {
        return replace(str, startInclude, endExclude, '*');
    }

    public static String subAfter(CharSequence string, CharSequence separator, boolean isLastSeparator) {
        if (isEmpty(string)) {
            return null == string ? null : string.toString();
        } else if (separator == null) {
            return "";
        } else {
            String str = string.toString();
            String sep = separator.toString();
            int pos = isLastSeparator ? str.lastIndexOf(sep) : str.indexOf(sep);
            return -1 != pos && string.length() - 1 != pos ? str.substring(pos + separator.length()) : "";
        }
    }
}
