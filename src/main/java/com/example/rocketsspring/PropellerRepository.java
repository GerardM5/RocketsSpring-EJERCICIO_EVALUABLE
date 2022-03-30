package com.example.rocketsspring;

import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
import java.util.List;

public interface PropellerRepository extends CrudRepository<Propeller, String> {
    @Transactional
    List<Propeller> deleteAllByRocket(Rocket rocket);
}
