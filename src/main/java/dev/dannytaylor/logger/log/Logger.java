package dev.dannytaylor.logger.log;

import dev.dannytaylor.logger.log.handler.Handler;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Logger {
	public final DateTimeFormatter dateTimeFormatter;
	private final List<Handler> handlers;
	public Logger() {
		dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		this.handlers = new ArrayList<>();
	}
	public List<Handler> getHandlers() {
		return this.handlers;
	}
	public void registerHandler(Handler handler) {
		this.handlers.add(handler.setDateTimeFormatter(dateTimeFormatter));
	}
	private void log(Type type, String message) {
		for (Handler handler : this.handlers) handler.log(type, message);
	}
	public void log(String message, String style) {
		for (Handler handler : this.handlers) handler.log(message, style);
	}
	public void log(StringBuilder message, String style) {
		for (Handler handler : this.handlers) handler.log(message.toString(), style);
	}
	public void unformatted(String message) {
		log(message, Logger.Type.unformatted.name());
	}
	public void unformatted(StringBuilder message) {
		log(message, Logger.Type.unformatted.name());
	}
	public void info(String message) {
		log(Type.info, message);
	}
	public void info(StringBuilder message) {
		log(Type.info, message.toString());
	}
	public void warn(String message) {
		log(Type.warn, message);
	}
	public void warn(StringBuilder message) {
		log(Type.warn, message.toString());
	}
	public void error(String message) {
		log(Type.error, message);
	}
	public void error(StringBuilder message) {
		log(Type.error, message.toString());
	}
	public void debug(String message) {
		log(Type.debug, message);
	}
	public void debug(StringBuilder message) {
		log(Type.debug, message.toString());
	}
	public void close() {
		for (Handler handler : this.handlers) handler.close();
	}
	public enum Type {
		unformatted(""),
		info("INFO"),
		warn("WARNING"),
		error("ERROR"),
		debug("DEBUG");
		private final String prefix;
		Type(String prefix) {
			this.prefix = prefix;
		}
		public String getPrefix() {
			return this.prefix;
		}
	}
}
