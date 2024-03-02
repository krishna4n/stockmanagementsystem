package com.IT.Stock.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IT.Stock.Model.Item;

@Repository
public interface ItemJpaRepository extends JpaRepository<Item,Long> {}
