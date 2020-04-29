package com.zoo.assignment.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.zoo.assignment.dto.ZooDTO;

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
@Table(name="ZOO")
public class Zoo {
	
	public static Zoo of (ZooDTO zoo) {
		return new Zoo(zoo.getId(),zoo.getName(),zoo.getLocation(),zoo.getTotal(),null);
	}
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO,generator="native")
    @GenericGenerator(
    	    name = "native",
    	    strategy = "native"
    	)	
	@Column(name = "ZOO_ID")
	private Long id;
	@Column(name = "ZOO_NAME")
	private String name;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "TOTAL_ANIMAL" )
	private Long total;
	@OneToMany(mappedBy = "zoo", cascade = CascadeType.ALL)
	private List<Animal> animals;
}
