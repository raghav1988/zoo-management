package com.zoo.assignment.dto;

import com.zoo.assignment.entity.Animal;

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
	private String name;
	private Long count;
	private String type;

	public static AnimalDTO of(Animal animal) {
		return new AnimalDTO(animal.getId(), animal.getName(), animal.getCount(), animal.getType());
	}
}
