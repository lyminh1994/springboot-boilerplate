package vn.com.minhlq.boilerplate.util;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vn.com.minhlq.boilerplate.BoilerplateApplicationTests;
import vn.com.minhlq.boilerplate.common.PageResult;
import vn.com.minhlq.boilerplate.constant.CommonConst;

/**
 * <p>
 * Test RedisUtil
 * </p>
 */
@Slf4j
public class RedisUtilTest extends BoilerplateApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void findKeysForPage() {
        PageResult<String> pageResult = redisUtil.findKeysForPage(CommonConst.REDIS_JWT_KEY_PREFIX + CommonConst.SYMBOL_STAR, 2, 1);
        log.info("[pageResult]= {}", JSONUtil.toJsonStr(pageResult));
    }
}