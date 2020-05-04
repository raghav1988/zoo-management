package com.zoo.assignment.service;

import java.util.List;

import com.zoo.assignment.dto.AnimalDTO;

public interface MammalService {

	List<AnimalDTO> getAllAnimalByZooId(Long id);

	AnimalDTO create(Long id, AnimalDTO animal);
}
