package dev.dannytaylor.logger.log.handler.handlers;

import dev.dannytaylor.logger.log.Logger;
import dev.dannytaylor.logger.log.handler.Handler;

import java.io.*;

public class FileHandler extends Handler {
	private final PrintWriter writer;
	public FileHandler(File file) throws IOException {
		File parent = file.getParentFile();
		if (parent != null && !parent.exists()) parent.mkdirs();
		this.writer = new PrintWriter(new BufferedWriter(new FileWriter(file, true)), true);
	}
	public void log(Logger.Type type, String message) {
		log(format(type, message), "");
	}
	public void log(String log, String style) {
		this.writer.println(log);
	}
	public void close() {
		writer.close();
	}
}
