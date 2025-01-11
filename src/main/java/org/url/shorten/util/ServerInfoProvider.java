package org.url.shorten.util;

import org.springframework.beans.factory.annotation.Value;

public class ServerInfoProvider {
	@Value("${server.address}")
	private static String serverAddress;

	@Value("${server.port}")
	private static int serverPort;

	public static String getBaseUrl() {
		return String.format("http://%s:%d",
			serverAddress == null ? "localhost" : serverAddress,
			serverPort == 0 ? 8080 : serverPort
		);
	}
}
