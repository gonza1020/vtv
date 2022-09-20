package com.certant.vtv.repository;


import com.certant.vtv.model.Inspector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InspectorRepository extends JpaRepository<Inspector,Long> {
}
