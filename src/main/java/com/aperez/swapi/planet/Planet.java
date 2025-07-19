package com.aperez.swapi.planet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "planet")
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
    @Id
    @Column(name="id")
    private Long id;
    @Column(name = "name")
    private String name;
}
