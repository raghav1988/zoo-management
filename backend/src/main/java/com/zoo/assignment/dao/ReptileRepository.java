package com.zoo.assignment.dao;

import java.util.List;

import com.zoo.assignment.entity.Reptile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReptileRepository extends JpaRepository<Reptile, Long> {

	List<Reptile> findByZooId(Long zooId);
}
