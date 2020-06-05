package vn.com.minhlq.boilerplate.util;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import vn.com.minhlq.boilerplate.common.PageResult;

import java.util.Collection;
import java.util.List;

/**
 * <p>
 * Redis Tools
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.util
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
@Component
public class RedisUtil {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    /**
     * Get the specified format key by page, and use the scan command instead of the keys command to improve the query efficiency in the case of a large amount of data
     *
     * @param patternKey  Key format
     * @param currentPage Current page number
     * @param pageSize    Element per page
     * @return Get the specified format key by page
     */
    public PageResult<String> findKeysForPage(String patternKey, int currentPage, int pageSize) {
        ScanOptions options = ScanOptions.scanOptions()
                .match(patternKey)
                .build();
        RedisConnectionFactory factory = stringRedisTemplate.getConnectionFactory();
        RedisConnection rc = factory.getConnection();
        Cursor<byte[]> cursor = rc.scan(options);

        List<String> result = Lists.newArrayList();

        long tmpIndex = 0;
        int startIndex = (currentPage - 1) * pageSize;
        int end = currentPage * pageSize;
        while (cursor.hasNext()) {
            String key = new String(cursor.next());
            if (tmpIndex >= startIndex && tmpIndex < end) {
                result.add(key);
            }
            tmpIndex++;
        }

        try {
            cursor.close();
            RedisConnectionUtils.releaseConnection(rc, factory);
        } catch (Exception e) {
            log.warn("Redis连接关闭异常，", e);
        }

        return new PageResult<>(result, tmpIndex);
    }

    /**
     * Delete key in Redis
     *
     * @param key Key
     */
    public void delete(String key) {
        stringRedisTemplate.delete(key);
    }

    /**
     * Batch delete some keys in Redis
     *
     * @param keys Key list
     */
    public void delete(Collection<String> keys) {
        stringRedisTemplate.delete(keys);
    }
}
