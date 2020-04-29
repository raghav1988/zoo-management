package com.zoo.assignment.controller;

import java.util.List;

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
import com.zoo.assignment.service.AnimalService;

@RestController
@RequestMapping("/api")
public class AnimalController {

	@Autowired 
	private AnimalService animalService;
	
	@GetMapping("/zoo/{id}/animal")
	public ResponseEntity<List<AnimalDTO>> getAllAnimalByZooId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body( animalService.getAllAnimalByZooId(id));
	}
	
	@GetMapping("/zoo/{zooId}/animal/{animalId}")
	public ResponseEntity<List<AnimalDTO>> getAnimalByAnimalIdAndZooId(@PathVariable Long id) {
		return ResponseEntity.status(HttpStatus.OK).body( animalService.getAllAnimalByZooId(id));
	}
	
	@PostMapping("/zoo/{id}/animal")
	public AnimalDTO create(@PathVariable Long id, @RequestBody AnimalDTO animal) {
		return animalService.create(id, animal);
	}
}
