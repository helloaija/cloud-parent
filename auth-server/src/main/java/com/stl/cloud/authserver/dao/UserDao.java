package com.stl.cloud.authserver.dao;

import com.stl.cloud.authserver.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 用户DAO
 * @author shitl
 */
public interface UserDao extends JpaRepository<UserEntity, Long> {
    UserEntity findByUsername(String username);

}
