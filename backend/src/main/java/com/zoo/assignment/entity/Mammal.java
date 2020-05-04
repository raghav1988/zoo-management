package com.zoo.assignment.entity;

import java.util.Date;

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
@Table(name = "Mammal")
public class Mammal extends Animal {

	private Date birthdate;

	public static Mammal of(AnimalDTO animal) {
		return new Mammal(animal.getId(), animal.getName(), animal.getCount(), animal.getAnimalType(),
				animal.getBirthdate());
	}

	public Mammal(Long id, String name, Long count, AnimalType type, Date birthdate) {
		super(id, name, count, type);
		this.birthdate = birthdate;
	}
}
