package com.zoo.assignment.dao;

import java.util.List;

import com.zoo.assignment.entity.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

	List<Animal> findByZooId(Long zooId);
}
