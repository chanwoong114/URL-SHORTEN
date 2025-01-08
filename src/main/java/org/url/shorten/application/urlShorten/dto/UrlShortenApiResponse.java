package org.url.shorten.application.urlShorten.dto;

public record UrlShortenApiResponse(
	long id,
	String urlHashCode,
	String url
) {

	public static UrlShortenApiResponse of(long id, String urlHashCode, String url) {
		return new UrlShortenApiResponse(id, urlHashCode, url);
	}
}
