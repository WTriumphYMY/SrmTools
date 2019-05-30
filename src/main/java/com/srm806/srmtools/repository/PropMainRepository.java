package com.srm806.srmtools.repository;

import com.srm806.srmtools.domain.PropellantMainParas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropMainRepository extends JpaRepository<PropellantMainParas, Integer> {
    PropellantMainParas findBySrmName(String srmName);
}
