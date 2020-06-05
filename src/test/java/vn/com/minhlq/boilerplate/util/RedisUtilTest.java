package vn.com.minhlq.boilerplate.util;

import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import vn.com.minhlq.boilerplate.BoilerplateApplicationTests;
import vn.com.minhlq.boilerplate.common.Consts;
import vn.com.minhlq.boilerplate.common.PageResult;

/**
 * <p>
 * 测试RedisUtil
 * </p>
 *
 * @package:
 * @description:
 * @author: MinhLQ
 * @date: Created in 2020-06-04 14:15
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
@Slf4j
public class RedisUtilTest extends BoilerplateApplicationTests {

    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void findKeysForPage() {
        PageResult<String> pageResult = redisUtil.findKeysForPage(Consts.REDIS_JWT_KEY_PREFIX + Consts.SYMBOL_STAR, 2, 1);
        log.info("【pageResult】= {}", JSONUtil.toJsonStr(pageResult));
    }
}