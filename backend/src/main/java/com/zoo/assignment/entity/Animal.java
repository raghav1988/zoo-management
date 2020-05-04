package com.zoo.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

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
@Table(name = "ANIMAL")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	@Column(name = "ANIMAL_ID")
	private Long id;
	@Column(name = "NAME")
	private String name;
	@Column(name = "COUNT")
	private Long count;
	@Column(name = "TYPE")
	@Enumerated(EnumType.STRING)
	private AnimalType type;
	@ManyToOne
	@JoinColumn(name = "Zoo_ID_FK")
	private Zoo zoo;

	public static Animal of(AnimalDTO animal) {
		return new Animal(animal.getId(), animal.getName(), animal.getCount(), animal.getAnimalType());
	}

	Animal(Long id, String name, Long count, AnimalType type) {
		this.setId(id);
		this.setName(name);
		this.setCount(count);
		this.setType(type);
	}
}
