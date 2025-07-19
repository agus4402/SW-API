package com.aperez.swapi;

import com.aperez.swapi.character.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public interface ICrudService<T, ID> {
	public List<T> getAll();
	public T getById(ID id);
	public T save(T entity);
	public T update(ID id, Map<String, Object> fields);
	public void delete(ID id);
	public Optional<T> exists(ID id);
}
