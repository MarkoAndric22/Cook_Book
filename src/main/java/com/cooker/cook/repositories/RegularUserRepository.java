package com.cooker.cook.repositories;

import com.cooker.cook.entities.RegularUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegularUserRepository extends JpaRepository<RegularUser,Long> {
}
