package com.myspringproject.demo.repository;

import com.myspringproject.demo.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> getItemById(Long id);
}
