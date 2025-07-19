package com.aperez.swapi.character;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

public class CharacterConfig {
	@Bean
	CommandLineRunner commandLineRunner(CharacterService characterService) {
		return args -> {};
	}
}
