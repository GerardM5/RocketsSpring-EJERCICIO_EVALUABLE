package com.example.rocketsspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PropellerRepository extends JpaRepository<Propeller, String> {
    @Transactional
    List<Propeller> deleteAllByRocket(Rocket rocket);
}
