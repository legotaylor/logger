package dev.dannytaylor.logger.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Timestamp {
	public static String get(DateTimeFormatter formatter) {
		return LocalDateTime.now().format(formatter);
	}
}
