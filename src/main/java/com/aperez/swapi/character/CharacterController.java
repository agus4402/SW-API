package com.aperez.swapi.character;

import com.aperez.swapi.ICrudController;
import com.aperez.swapi.response.Response;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "character")
public class CharacterController implements ICrudController<Character, Long> {

	private final CharacterService characterService;

	@Override
	public ResponseEntity<Object> getById(@RequestParam Long id) {
		try {
			return ResponseEntity.ok(Response.of("",characterService.getById(id)));
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<List<Character>> getAll() {
		return ResponseEntity.ok(characterService.getAll());
	}

	@Override
	public ResponseEntity<Object> post(@RequestBody Character character) {
		try {
			Character newCharacter = characterService.save(character);
			return ResponseEntity.ok(newCharacter);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Object> patch(@RequestParam Long id, @RequestBody Map<String, Object> fields) {
		try {
			Character newCharacter = characterService.update(id, fields);
			return ResponseEntity.ok(newCharacter);
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}

	@Override
	public ResponseEntity<Object> delete(@RequestParam Long id) {
		try {
			characterService.delete(id);
			return ResponseEntity.ok("Character with id " + id + " deleted");
		} catch (IllegalArgumentException e) {
			return ResponseEntity.badRequest()
					.body(e.getMessage());
		}
	}
}
