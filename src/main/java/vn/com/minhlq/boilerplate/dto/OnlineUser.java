package vn.com.minhlq.boilerplate.dto;

import cn.hutool.core.bean.BeanUtil;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import vn.com.minhlq.boilerplate.common.CommonConst;
import vn.com.minhlq.boilerplate.model.User;
import vn.com.minhlq.boilerplate.util.StringUtil;

/**
 * <p>
 * Online users dto
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.dto
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
     * Primary key
     */
    private Long id;

    /**
     * Username
     */
    private String username;

    /**
     * Nick name
     */
    private String nickname;

    /**
     * Phone numbers
     */
    private String phone;

    /**
     * Email
     */
    private String email;

    /**
     * Birthday
     */
    private Long birthday;

    /**
     * Gender, male-1, female-2
     */
    private Integer sex;

    public static OnlineUser create(User user) {
        OnlineUser onlineUser = new OnlineUser();
        BeanUtil.copyProperties(user, onlineUser);
        // Desensitization
        onlineUser.setPhone(StringUtil.hide(user.getPhone(), 3, 7));
        onlineUser.setEmail(StringUtil.hide(user.getEmail(), 1, StringUtils.indexOfIgnoreCase(user.getEmail(), CommonConst.SYMBOL_EMAIL)));
        return onlineUser;
    }
}
