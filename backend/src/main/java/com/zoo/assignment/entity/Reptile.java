package com.zoo.assignment.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.zoo.assignment.dto.AnimalDTO;
import com.zoo.assignment.enums.AnimalType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "Reptile")
public class Reptile extends Animal {

	private Float length;

	public Reptile(Long id, String name, Long count, AnimalType type, Float length) {
		super(id, name, count, type);
		this.length = length;
	}
	
	public static Reptile of(AnimalDTO animal) {
		return new Reptile(animal.getId(), animal.getName(), animal.getCount(), animal.getAnimalType(), animal.getLength());
	}

}
