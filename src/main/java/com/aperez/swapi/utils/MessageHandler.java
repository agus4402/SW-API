package com.aperez.swapi.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.function.Supplier;

@Component
@RequiredArgsConstructor
public class MessageHandler {

	private final MessageSource messageSource;

	public  String getMessage(String key, Object[] args, Locale locale) {
		return messageSource.getMessage(key, args, locale);
	}

	public  String getMessage(String key, Object[] args) {
		return messageSource.getMessage(key, args, Locale.getDefault()) + "(" + Locale.getDefault() + ")";
	}
}
