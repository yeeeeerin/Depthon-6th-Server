package com.example.depthon3hangshi.repository;

import com.example.depthon3hangshi.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
