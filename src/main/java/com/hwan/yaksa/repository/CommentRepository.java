package com.hwan.yaksa.repository;

import com.hwan.yaksa.domain.Board;
import com.hwan.yaksa.domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment,Long> {

    public Optional<Board> findByBoardId(Long Id);
}
