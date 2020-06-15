package vn.com.minhlq.boilerplate.dto;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import vn.com.minhlq.boilerplate.constant.CommonConst;
import vn.com.minhlq.boilerplate.model.User;
import vn.com.minhlq.boilerplate.util.StringUtil;

/**
 * <p>
 * Online users dto
 * </p>
 */
@Data
public class OnlineUserDto {

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

    public static OnlineUserDto create(User user) {
        OnlineUserDto onlineUser = new OnlineUserDto();
        onlineUser.setNickname(user.getNickname());
        onlineUser.setBirthday(user.getBirthday());
        onlineUser.setSex(user.getSex());
        // Desensitization
        onlineUser.setUsername(StringUtil.hide(user.getUsername(), 1, user.getUsername().length() / 2));
        onlineUser.setPhone(StringUtil.hide(user.getPhone(), 3, 7));
        onlineUser.setEmail(StringUtil.hide(user.getEmail(), 1, StringUtils.indexOfIgnoreCase(user.getEmail(), CommonConst.SYMBOL_EMAIL)));
        return onlineUser;
    }
}
