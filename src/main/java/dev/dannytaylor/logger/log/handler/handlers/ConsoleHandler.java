package dev.dannytaylor.logger.log.handler.handlers;

import dev.dannytaylor.logger.log.Logger;
import dev.dannytaylor.logger.log.handler.Handler;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ConsoleHandler extends Handler {
	private final Map<String, Color> styles = new HashMap<>();
	public void log(Logger.Type type, String message) {
		log(format(type, message), "");
	}
	public void log(String log, String style) {
		System.out.println(ansiColor(styles.get(style)) + log + "\u001B[0m");
	}
	public void addStyle(String id, Color color) {
		styles.put(id, color);
	}
	public Map<String, Color> getStyles() {
		return styles;
	}
	public String ansiColor(Color color) {
		return "\u001B[38;2;" + color.getRed() + ";" + color.getGreen() + ";" + color.getBlue() + "m";
	}
}