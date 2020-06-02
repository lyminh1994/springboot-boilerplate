package vn.com.minhlq.boilerplate.dto;

import lombok.Data;
import vn.com.minhlq.boilerplate.model.User;


@Data
public class OnlineUser {

    private Long id;

    private String username;

    private String nickname;

    private String phone;

    private String email;

    private Long birthday;

    private Integer sex;

    public static OnlineUser create(User user) {
        OnlineUser onlineUser = new OnlineUser();
        onlineUser.setId(user.getId());
        onlineUser.setUsername(user.getUsername());
        onlineUser.setNickname(user.getNickname());
        onlineUser.setPhone(user.getPhone());
        onlineUser.setEmail(user.getEmail());
        onlineUser.setBirthday(user.getBirthday());
        onlineUser.setSex(user.getSex());
        return onlineUser;
    }
}
