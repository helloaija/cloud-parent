package com.stl.cloud.servicefeign;

import com.stl.cloud.servicefeign.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户DAO
 * @author shitl
 */
public interface UserDao extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);
}
