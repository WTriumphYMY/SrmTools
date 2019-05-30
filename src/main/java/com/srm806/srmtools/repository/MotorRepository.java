package com.srm806.srmtools.repository;

import com.srm806.srmtools.domain.RocketParas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MotorRepository extends JpaRepository<RocketParas, Integer> {
    public RocketParas findBySrmName(String srmName);
}
