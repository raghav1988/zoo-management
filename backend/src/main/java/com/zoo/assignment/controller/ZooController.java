package com.zoo.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zoo.assignment.dto.ZooDTO;
import com.zoo.assignment.service.ZooService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ZooController {

	@Autowired
	private ZooService zooService;

	@GetMapping("/zoo")
	public ResponseEntity<List<ZooDTO>> getAll() {
		return ResponseEntity.status(HttpStatus.OK).body(zooService.getAll());
	}
	
	@GetMapping("/zoo/{id}")
	public ResponseEntity<ZooDTO> getZooById(@PathVariable Long id ) {
		return ResponseEntity.status(HttpStatus.OK).body(zooService.getZooById(id));
	}

	@PostMapping("/zoo")
	public ResponseEntity<ZooDTO> create(@RequestBody ZooDTO zoo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(zooService.create(zoo));
	}
	
	@PutMapping("/zoo/{id}")
	public ResponseEntity<ZooDTO> update(@PathVariable Long id ,@RequestBody ZooDTO zoo) {
		return ResponseEntity.status(HttpStatus.OK).body(zooService.update(id,zoo));
	}

}
