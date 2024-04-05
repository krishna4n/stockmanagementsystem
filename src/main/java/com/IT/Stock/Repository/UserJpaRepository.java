package com.IT.Stock.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.IT.Stock.Model.User;

public interface UserJpaRepository extends JpaRepository<User, Long>{
    User findByUsername(String username);
}
