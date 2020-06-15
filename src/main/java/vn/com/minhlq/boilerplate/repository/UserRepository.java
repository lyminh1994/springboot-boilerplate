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
 */
public interface UserRepository extends JpaRepository<User, Long>, JpaSpecificationExecutor<User> {

    /**
     * Query users based on username
     *
     * @param username UserName
     * @return Optional user
     */
    Optional<User> findByUsername(String username);

    /**
     * Query user list according to user name list
     *
     * @param usernameList UserName List
     * @return List user
     */
    List<User> findByUsernameIn(List<String> usernameList);

}
