package com.hwan.yaksa.item;

import com.hwan.yaksa.domain.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image,Long> {
}
