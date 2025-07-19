package com.aperez.swapi.specie;

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
@Table(name = "specie")
@AllArgsConstructor
@NoArgsConstructor
public class Specie {
    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
}
