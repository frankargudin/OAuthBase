package com.oauth.oauthbase.repository;

import com.oauth.oauthbase.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Integer> {

    @Query("Select u from User u where u.username = :usuario and u.password = :password")
    User findByUsernameAndPassword(@Param("usuario") String usuario, @Param("password") String password);
}
