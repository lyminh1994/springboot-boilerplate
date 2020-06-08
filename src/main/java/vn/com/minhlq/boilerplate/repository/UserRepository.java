package vn.com.minhlq.boilerplate.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import vn.com.minhlq.boilerplate.model.User;

import java.util.List;
import java.util.Optional;

/**
 * <p>
 * User Repository
 * </p>
 *
 * @package: vn.com.minhlq.boilerplate.repositories
 * @description: User Repository
 * @author: MinhLQ
 * @date: Created in 2020-06-01 21:00
 * @copyright: Copyright (c) 2020
 * @version: v1.0
 * @modified: MinhLQ
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * Query users based on username, email and phone numbers
     *
     * @param username UserName
     * @param email    Email
     * @param phone    Phone numbers
     * @return Optional user
     */
    Optional<User> findByUsernameOrEmailOrPhone(String username, String email, String phone);

    /**
     * Query user list according to user name list
     *
     * @param usernameList UserName List
     * @return List user
     */
    List<User> findByUsernameIn(List<String> usernameList);

}
