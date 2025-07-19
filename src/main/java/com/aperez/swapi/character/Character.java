package com.aperez.swapi.character;

import com.aperez.swapi.weapon.Weapon;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import jdk.jfr.Name;
import lombok.*;
import com.aperez.swapi.planet.Planet;
import com.aperez.swapi.specie.Specie;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "character_info")
public class Character {
	@Id
	@Min(value = 1, message = "Id must be greater than 0")
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@OneToOne
	@JoinColumn(name = "specie_id")
	private Specie species;

	@OneToOne
	@JoinColumn(name = "homeworld_id")
	private Planet homePlanet;

	@OneToOne
	@JoinColumn(name = "weapon_id")
	private Weapon weapon;
}

