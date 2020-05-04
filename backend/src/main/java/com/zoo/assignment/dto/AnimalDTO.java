package com.zoo.assignment.dto;

import java.util.Date;

import javax.validation.constraints.NotBlank;

import com.zoo.assignment.entity.Animal;
import com.zoo.assignment.entity.Mammal;
import com.zoo.assignment.entity.Reptile;
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
public class AnimalDTO {

	private Long id;
	@NotBlank
	private String name;
	private Long count;
	private AnimalType animalType;
	private Date birthdate;
	private Float length;

	public static AnimalDTO of(Mammal mammal) {
		return new AnimalDTO(mammal.getId(), mammal.getName(), mammal.getCount(), mammal.getType(),
				mammal.getBirthdate());
	}

	public static AnimalDTO of(Reptile reptile) {
		return new AnimalDTO(reptile.getId(), reptile.getName(), reptile.getCount(), reptile.getType(),
				reptile.getLength());
	}
	
	public static AnimalDTO of(Animal animal) {
		return new AnimalDTO(animal.getId(), animal.getName(), animal.getCount(), animal.getType());
	}

	private AnimalDTO(Long id, String name, Long count, AnimalType animalType, Date birthdate) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.animalType = animalType;
		this.birthdate = birthdate;
	}

	private AnimalDTO(Long id, String name, Long count, AnimalType animalType, Float length) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.animalType = animalType;
		this.length = length;
	}

	private AnimalDTO(Long id, String name, Long count, AnimalType animalType) {
		this.id = id;
		this.name = name;
		this.count = count;
		this.animalType = animalType;
	}
	
	

}
