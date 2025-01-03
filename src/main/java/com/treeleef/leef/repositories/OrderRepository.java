package com.treeleef.leef.repositories;

import com.treeleef.leef.models.Order;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends CrudRepository<Order, Long> {
    List<Order> findAllByUserId(Long userId);
}
