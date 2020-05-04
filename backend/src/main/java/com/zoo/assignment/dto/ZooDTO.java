package com.zoo.assignment.dto;

import javax.validation.constraints.NotBlank;

import com.zoo.assignment.entity.Zoo;

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
public class ZooDTO {

	private Long id;
	@NotBlank
	private String name;
	@NotBlank
	private String location;
	private Long total;

	public static ZooDTO of(Zoo zoo) {
		return new ZooDTO(zoo.getId(), zoo.getName(), zoo.getLocation(),zoo.getTotal());
	}
}
