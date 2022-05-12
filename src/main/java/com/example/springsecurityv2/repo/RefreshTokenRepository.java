package com.example.springsecurityv2.repo;

import com.example.springsecurityv2.modal.RefreshToken;
import com.example.springsecurityv2.modal.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long>  {
    Optional<RefreshToken> findByToken(String token);
    @Modifying
    Long deleteByUser(User user);

}
