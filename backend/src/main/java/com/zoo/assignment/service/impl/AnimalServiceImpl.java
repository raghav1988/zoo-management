package com.zoo.assignment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import com.zoo.assignment.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.assignment.dao.AnimalRepository;
import com.zoo.assignment.dao.ZooRepository;
import com.zoo.assignment.dto.AnimalDTO;
import com.zoo.assignment.entity.Animal;
import com.zoo.assignment.entity.Zoo;
import com.zoo.assignment.service.AnimalService;

@Service
@Transactional
public class AnimalServiceImpl implements AnimalService {

	@Autowired
	private AnimalRepository animalRepository;

	@Autowired
	private ZooRepository zooRepository;

	@Override
	public List<AnimalDTO> getAllAnimalByZooId(Long id) {

		return animalRepository.findByZooId(id).stream().map(AnimalDTO::of).collect(Collectors.toList());
	}

	@Override
	public AnimalDTO create(Long id, AnimalDTO animal) {
		Optional<Zoo> optional = zooRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException();
		}
		Zoo zoo = optional.get();
		Animal persistAnimal = new Animal();
		persistAnimal.setName(animal.getName());
		persistAnimal.setType(animal.getType());
		Long count = Long.valueOf(0);
		if(animal.getCount()!=null)
			count = animal.getCount();
		persistAnimal.setCount(count);
		persistAnimal.setZoo(zoo);
		AnimalDTO dto = AnimalDTO.of(animalRepository.save(persistAnimal));
		zoo.setTotal(dto.getCount()+zoo.getTotal());
		zooRepository.save(zoo);
		return dto;
	}
}
