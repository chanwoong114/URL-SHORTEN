package org.url.shorten.application.urlShorten.dto;

import org.url.shorten.util.ServerInfoProvider;

public record CreateUrlApiResponse(
	int urlEncodingType,
	String encodedId
) {

	public static CreateUrlApiResponse of(int urlEncodingType, String encodedId) {
		return new CreateUrlApiResponse(urlEncodingType, encodedId);
	}

	public String toUrl() {
		return String.format(ServerInfoProvider.getBaseUrl() + "/%d/%s", urlEncodingType, encodedId);
	}
}
