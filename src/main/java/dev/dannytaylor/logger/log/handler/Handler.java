package dev.dannytaylor.logger.log.handler;

import dev.dannytaylor.logger.log.Logger;
import dev.dannytaylor.logger.util.Timestamp;

import java.time.format.DateTimeFormatter;

public abstract class Handler {
	public DateTimeFormatter dateTimeFormatter;
	public Handler() {
		this.dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	}
	public Handler setDateTimeFormatter(DateTimeFormatter dateTimeFormatter) {
		this.dateTimeFormatter = dateTimeFormatter;
		return this;
	}
	public abstract void log(Logger.Type type, String log);
	public abstract void log(String log, String style);
	public String format(Logger.Type type, String log) {
		return String.format("[%s] [%s] %s", Timestamp.get(dateTimeFormatter), type.getPrefix(), log);
	}
	public void close() {
	}
}