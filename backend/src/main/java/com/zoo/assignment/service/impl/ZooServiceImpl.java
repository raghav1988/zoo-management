package com.zoo.assignment.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zoo.assignment.dao.ZooRepository;
import com.zoo.assignment.dto.ZooDTO;
import com.zoo.assignment.entity.Zoo;
import com.zoo.assignment.exception.ResourceNotFoundException;
import com.zoo.assignment.service.ZooService;

@Service
public class ZooServiceImpl implements ZooService {

	@Autowired
	private ZooRepository zooRepository;

	@Override
	public List<ZooDTO> getAll() {
		return zooRepository.findAll().stream().map(ZooDTO::of).collect(Collectors.toList());
	}

	@Override
	public ZooDTO create(ZooDTO zoo) {
		if (zoo.getTotal() == null)
			zoo.setTotal(Long.valueOf(0));
		Zoo persistZoo = zooRepository.save(Zoo.of(zoo));
		return ZooDTO.of(persistZoo);
	}

	@Override
	public ZooDTO update(Long id, ZooDTO zoo) {
		Optional<Zoo> optional = zooRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException();
		}
		Zoo persistZoo = optional.get();
		persistZoo.setLocation(zoo.getLocation());
		persistZoo.setName(zoo.getName());
		if (zoo.getTotal() != null)
			persistZoo.setTotal(persistZoo.getTotal() + zoo.getTotal());
		return ZooDTO.of(zooRepository.save(persistZoo));
	}

	@Override
	public ZooDTO getZooById(Long id) {
		Optional<Zoo> optional = zooRepository.findById(id);
		if (!optional.isPresent()) {
			throw new ResourceNotFoundException();
		}
		return ZooDTO.of(optional.get());
	}

}
