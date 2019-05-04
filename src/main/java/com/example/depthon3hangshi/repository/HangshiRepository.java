package com.example.depthon3hangshi.repository;

import com.example.depthon3hangshi.domain.Hangshi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HangshiRepository extends JpaRepository<Hangshi,Long> {
    Page<Hangshi> findAllByOrderByLikeCountDesc(Pageable pageable);

    Page<Hangshi> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
