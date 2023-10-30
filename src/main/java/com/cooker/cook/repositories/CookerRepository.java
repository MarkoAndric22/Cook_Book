package com.cooker.cook.repositories;

import com.cooker.cook.entities.Cooker;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CookerRepository extends JpaRepository <Cooker,Long> {
}
