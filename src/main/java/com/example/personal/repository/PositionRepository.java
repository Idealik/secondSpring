package com.example.personal.repository;

import com.example.personal.domain.Position;
import org.springframework.data.repository.CrudRepository;

public interface PositionRepository extends CrudRepository<Position, Integer> {
    Position findById(int id);
}
