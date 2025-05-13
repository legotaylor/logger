package dev.dannytaylor.logger.log.handler.handlers;

import dev.dannytaylor.logger.log.Logger;
import dev.dannytaylor.logger.log.handler.Handler;

public class ConsoleHandler extends Handler {
	public void log(Logger.Type type, String message) {
		log(format(type, message), "");
	}
	public void log(String log, String style) {
		System.out.println(log);
	}
}
