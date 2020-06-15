package vn.com.minhlq.boilerplate.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * General paging parameter return
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements Serializable {
    private static final long serialVersionUID = 3420391142991247367L;

    /**
     * Current page data
     */
    private List<T> rows;

    /**
     * Total number
     */
    private Long total;

    public static <T> PageResult of(List<T> rows, Long total) {
        return new PageResult<>(rows, total);
    }
}
