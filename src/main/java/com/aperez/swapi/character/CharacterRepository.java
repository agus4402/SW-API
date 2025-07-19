package com.aperez.swapi.character;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {
	@Query("SELECT c FROM Character c WHERE c.name = ?1")
	Optional<Character> findByName(String name);

	@Modifying
	@Query("UPDATE Character c SET c.name = ?1 WHERE c.id = ?2")
	void updateName(String name, Long id);


}
