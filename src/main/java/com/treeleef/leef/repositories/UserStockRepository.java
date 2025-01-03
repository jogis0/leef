package com.treeleef.leef.repositories;

import com.treeleef.leef.models.UserStock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStockRepository extends CrudRepository<UserStock, Long> {
    List<UserStock> findAllByUserId(Long userId);
}
