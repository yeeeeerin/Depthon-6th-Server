package com.example.depthon3hangshi.repository;

import com.example.depthon3hangshi.domain.Hangshi;
import com.example.depthon3hangshi.domain.LikeHangshi;
import com.example.depthon3hangshi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeHangshiRepository extends JpaRepository<LikeHangshi, Long> {

    Optional<LikeHangshi> findByHangshiAndUser(Hangshi hangshi, User user);
}
