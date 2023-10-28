package com.cooker.cook.repositories;

import com.cooker.cook.entities.Allergen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AllergenRepository extends JpaRepository <Allergen,Long> {
}
