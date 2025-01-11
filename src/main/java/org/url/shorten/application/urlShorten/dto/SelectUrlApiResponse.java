package org.url.shorten.application.urlShorten.dto;

public record SelectUrlApiResponse(
	long id,
	int urlEncodingType,
	String originalUrl
) {

	public static SelectUrlApiResponse of(long id, int urlEncodingType, String originalUrl) {
		return new SelectUrlApiResponse(id, urlEncodingType, originalUrl);
	}
}
