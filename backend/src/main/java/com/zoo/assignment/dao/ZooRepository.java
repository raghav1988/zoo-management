package com.zoo.assignment.dao;

import com.zoo.assignment.entity.Zoo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ZooRepository extends JpaRepository<Zoo, Long> {

}
