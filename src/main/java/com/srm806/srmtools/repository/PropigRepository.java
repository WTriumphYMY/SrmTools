package com.srm806.srmtools.repository;

import com.srm806.srmtools.domain.PropellantIgParas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropigRepository extends JpaRepository<PropellantIgParas, Integer> {
    public PropellantIgParas findBySrmName(String srmName);
}
