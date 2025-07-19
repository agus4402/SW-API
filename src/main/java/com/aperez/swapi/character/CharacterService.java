package com.aperez.swapi.character;

import com.aperez.swapi.ICrudService;
import com.aperez.swapi.utils.MessageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

@Service
@RequiredArgsConstructor
public class CharacterService {

	private final CharacterRepository characterRepository;
	private final MessageHandler messageHandler;

	public List<Character> getAll() {
		return characterRepository.findAll();
	}

	public Character save(Character character) {
		Optional<Character> existingCharacter = characterRepository.findByName(character.getName());
		if (existingCharacter.isPresent()) {
			throw new IllegalArgumentException(messageHandler.getMessage(
					"api.error.character.already.exists",
					new Object[]{character.getName()},
					Locale.ENGLISH
			));
		}
		characterRepository.save(character);
		return character;
	}

	public Character update(Long id, Map<String, Object> fields) {
		Optional<Character> target = exists(id);

		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Character.class, key);
			field.setAccessible(true);

			if (value instanceof Optional<?> optionalValue) {
				optionalValue.ifPresent(o -> ReflectionUtils.setField(field, target.orElseThrow(
						getIllegalArgumentExceptionSupplier(id)
				), o));
			} else {
				ReflectionUtils.setField(field, target.orElseThrow(
						getIllegalArgumentExceptionSupplier(id)
				), value);
			}
		});
		return characterRepository.save(target.orElseThrow(
				getIllegalArgumentExceptionSupplier(id)
		));
	}

	public void delete(Long id) {
		Optional<Character> target = exists(id);
		if (target.isEmpty()) {
			throw new IllegalArgumentException(messageHandler.getMessage(
					"api.error.character.not.found",
					new Object[]{id},
					Locale.ENGLISH
			));
		}
		characterRepository.deleteById(id);
	}

	public Character getById(Long id) {
		Optional<Character> target = characterRepository.findById(id);
		return target.orElseThrow(
				getIllegalArgumentExceptionSupplier(id)
		);
	}

	public Optional<Character> exists(Long id) {
		Optional<Character> target = characterRepository.findById(id);
		if (target.isEmpty()) {
			throw new IllegalArgumentException();
		}
		return target;
	}

	private Supplier<IllegalArgumentException> getIllegalArgumentExceptionSupplier(Long id) {
		return () -> new IllegalArgumentException(messageHandler.getMessage(
				"api.error.character.not.found",
				new Object[]{id}
		));
	}




}

