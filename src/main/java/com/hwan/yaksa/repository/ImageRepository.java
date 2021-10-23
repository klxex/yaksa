package com.hwan.yaksa.repository;

import com.hwan.yaksa.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
