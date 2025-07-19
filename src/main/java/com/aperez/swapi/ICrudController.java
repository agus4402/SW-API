package com.aperez.swapi;

import com.aperez.swapi.character.Character;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public interface ICrudController<T, ID> {
	@GetMapping(params = "id")
	public ResponseEntity<Object> getById(@RequestParam Long id);

	@GetMapping
	public ResponseEntity<List<T>> getAll();

	@PostMapping
	public ResponseEntity<Object> post(@RequestBody Character character);

	@PatchMapping
	public ResponseEntity<Object> patch(@RequestParam ID id, @RequestBody Map<String, Object> fields);

	@DeleteMapping
	public ResponseEntity<Object> delete(@RequestParam Long id);
}
