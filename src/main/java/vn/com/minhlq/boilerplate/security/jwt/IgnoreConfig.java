package vn.com.minhlq.boilerplate.security.jwt;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.List;

/**
 * <p>
 * Ignore configuration
 * </p>
 */
@Data
public class IgnoreConfig {
    /**
     * URL format to be ignored
     */
    private List<String> pattern = Lists.newArrayList();

    /**
     * GET request to be ignored
     */
    private List<String> get = Lists.newArrayList();

    /**
     * POST requests to be ignored
     */
    private List<String> post = Lists.newArrayList();

    /**
     * DELETE request to be ignored
     */
    private List<String> delete = Lists.newArrayList();

    /**
     * PUT request to be ignored
     */
    private List<String> put = Lists.newArrayList();

    /**
     * HEAD request to be ignored
     */
    private List<String> head = Lists.newArrayList();

    /**
     * PATCH request to be ignored
     */
    private List<String> patch = Lists.newArrayList();

    /**
     * OPTIONS request to be ignored
     */
    private List<String> options = Lists.newArrayList();

    /**
     * TRACE request to be ignore
     */
    private List<String> trace = Lists.newArrayList();
}
