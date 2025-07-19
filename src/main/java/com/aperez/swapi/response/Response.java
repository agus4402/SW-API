package com.aperez.swapi.response;

import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Setter
public class Response<T> {
	private final String message;
	private final T data;

	public static <T> Response<T> of(String message, T data) {
		return new Response<>(message, data);
	}
}
