package com.zoo.assignment.service;

import java.util.List;

import com.zoo.assignment.dto.ZooDTO;

public interface ZooService {
	
	List<ZooDTO> getAll();

	ZooDTO create(ZooDTO zoo);

	ZooDTO update(Long id, ZooDTO zoo);

	ZooDTO getZooById(Long id);
}
