package com.certant.vtv.repository;

import com.certant.vtv.model.Costumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CostumerRepository extends JpaRepository<Costumer,Long> {
    Costumer findByName(String name);

}
