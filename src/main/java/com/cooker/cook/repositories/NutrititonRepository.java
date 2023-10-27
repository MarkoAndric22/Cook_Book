package com.cooker.cook.repositories;

import com.cooker.cook.entities.Nutrition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NutrititonRepository extends JpaRepository<Nutrition,Integer> {
}
