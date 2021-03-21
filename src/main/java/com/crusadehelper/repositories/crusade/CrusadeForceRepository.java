package com.crusadehelper.repositories.crusade;

import com.crusadehelper.entities.CrusadeForce;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrusadeForceRepository extends JpaRepository<CrusadeForce, Integer> {
}
