package com.zoo.assignment.dao;

import java.util.List;

import com.zoo.assignment.entity.Mammal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MammalRepository extends JpaRepository<Mammal, Long>{

	List<Mammal> findByZooId(Long zooId);
}
