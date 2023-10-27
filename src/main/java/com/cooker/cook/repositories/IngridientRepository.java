package com.cooker.cook.repositories;

import com.cooker.cook.entities.Ingridient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngridientRepository extends JpaRepository<Ingridient,Integer> {
}
