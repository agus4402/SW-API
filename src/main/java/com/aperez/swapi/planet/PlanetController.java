package com.aperez.swapi.planet;

import com.aperez.swapi.ICrudController;
import com.aperez.swapi.character.Character;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "planet")
public class PlanetController implements ICrudController<Planet, Long> {
	private final PlanetService planetService;

	@Override
	public ResponseEntity<Object> getById(Long id) {
		return null;
	}

	@Override
	public ResponseEntity<List<Planet>> getAll() {
		return null;
	}

	@Override
	public ResponseEntity<Object> post(Character character) {
		return null;
	}

	@Override
	public ResponseEntity<Object> patch(Long aLong, Map<String, Object> fields) {
		return null;
	}

	@Override
	public ResponseEntity<Object> delete(Long id) {
		return null;
	}
}
