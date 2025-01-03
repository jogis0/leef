package com.treeleef.leef.repositories;

import com.treeleef.leef.models.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends CrudRepository<Stock, Long>  {
}
