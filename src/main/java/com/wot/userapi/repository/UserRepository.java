package com.wot.userapi.repository;

import com.wot.userapi.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByTxId (String txId);
    List<User> queryByNameLike (String name);
}
