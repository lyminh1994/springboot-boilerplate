package vn.com.minhlq.boilerplate.vo;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import lombok.Data;
import vn.com.minhlq.boilerplate.common.Consts;
import vn.com.minhlq.boilerplate.model.User;

/**
 * <p>
 * 在线用户 VO
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
@Data
public class OnlineUser {

    /**
     * 主键
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 昵称
     */
    private String nickname;

    /**
     * 手机
     */
    private String phone;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 生日
     */
    private Long birthday;

    /**
     * 性别，男-1，女-2
     */
    private Integer sex;

    public static OnlineUser create(User user) {
        OnlineUser onlineUser = new OnlineUser();
        BeanUtil.copyProperties(user, onlineUser);
        // 脱敏
        onlineUser.setPhone(StrUtil.hide(user.getPhone(), 3, 7));
        onlineUser.setEmail(StrUtil.hide(user.getEmail(), 1, StrUtil.indexOfIgnoreCase(user.getEmail(), Consts.SYMBOL_EMAIL)));
        return onlineUser;
    }
}
