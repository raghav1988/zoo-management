package com.zoo.assignment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zoo.assignment.dto.AnimalDTO;

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
	private String type;
	@ManyToOne
	@JoinColumn(name = "Zoo_ID_FK")	
	private Zoo zoo;
	
	public static Animal of (AnimalDTO animal) {
		return new Animal(animal.getId(),animal.getName(),animal.getCount(),animal.getType());
	}

	Animal(Long id, String name, Long count, String type) {
		this.setId(id);
		this.setName(name);
		this.setCount(count);
		this.setType(type);
	}
}
