package com.hwan.yaksa.item;

import com.hwan.yaksa.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface ItemRepository extends JpaRepository<Item,Long> {
        List<Item> findByNameContaining(String keyword);
}
