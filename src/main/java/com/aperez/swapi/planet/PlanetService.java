package com.aperez.swapi.planet;

import com.aperez.swapi.ICrudController;
import com.aperez.swapi.ICrudService;
import com.aperez.swapi.character.Character;
import com.aperez.swapi.utils.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PlanetService implements ICrudService<Planet,Long> {

	private final PlanetRepository planetRepository;
	private final MessageHandler messageHandler;

	@Override
	public List<Planet> getAll() {
		return null;
	}

	@Override
	public Planet getById(Long id) {
		Optional<Planet> planet = planetRepository.findById(id);
		return  planet.orElseThrow(() -> new IllegalArgumentException(messageHandler.getMessage(
				"api.error.character.not.found",
				new Object[]{id},
				Locale.ENGLISH
		)));
	}

	@Override
	public Planet save(Planet character) {
		return null;
	}

	@Override
	public Planet update(Long aLong, Map<String, Object> fields) {
		return null;
	}

	@Override
	public void delete(Long aLong) {

	}

	@Override
	public Optional<Planet> exists(Long aLong) {
		return Optional.empty();
	}
}
