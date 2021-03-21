package com.crusadehelper.repositories.crusade;

import com.crusadehelper.entities.Crusade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrusadeRepository extends JpaRepository<Crusade, Integer> {
}
