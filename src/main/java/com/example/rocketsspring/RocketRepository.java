package com.example.rocketsspring;

import org.springframework.data.repository.CrudRepository;

public interface RocketRepository extends CrudRepository <Rocket, String> {
}
