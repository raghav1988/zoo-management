package com.zoo.assignment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.assignment.dto.AnimalDTO;
import com.zoo.assignment.service.MammalService;
import com.zoo.assignment.service.Reptileservice;

@RestController
@RequestMapping("/api")
public class AnimalController {

	@Autowired
	private MammalService mammalService;

	@Autowired
	private Reptileservice reptileservice;

	@GetMapping("/zoo/{id}/mammal")
	public ResponseEntity<List<AnimalDTO>> getAllMammalByZooId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(mammalService.getAllAnimalByZooId(id));
	}

	@GetMapping("/zoo/{id}/reptile")
	public ResponseEntity<List<AnimalDTO>> getAllReptileByZooId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(reptileservice.getAllAnimalByZooId(id));
	}

	@GetMapping("/zoo/{zooId}/mammal/{animalId}")
	public ResponseEntity<List<AnimalDTO>> getMammalByAnimalIdAndZooId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(mammalService.getAllAnimalByZooId(id));
	}

	@GetMapping("/zoo/{zooId}/reptile/{animalId}")
	public ResponseEntity<List<AnimalDTO>> getReptileByAnimalIdAndZooId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(reptileservice.getAllAnimalByZooId(id));
	}

	@PostMapping("/zoo/{id}/mammal")
	public AnimalDTO createMammal(@PathVariable Long id, @RequestBody @Valid AnimalDTO animal) {
		return mammalService.create(id, animal);
	}

	@PostMapping("/zoo/{id}/reptile")
	public AnimalDTO createReptile(@PathVariable Long id, @RequestBody @Valid AnimalDTO animal) {
		return reptileservice.create(id, animal);
	}
}
