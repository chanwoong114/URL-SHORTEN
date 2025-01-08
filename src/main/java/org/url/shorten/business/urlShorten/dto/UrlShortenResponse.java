package org.url.shorten.business.urlShorten.dto;

import org.url.shorten.application.urlShorten.dto.UrlShortenApiResponse;
import org.url.shorten.util.ConvertDtoByPresentationLayer;

public record UrlShortenResponse(
	long id,
	String urlHashCode,
	String url
) implements ConvertDtoByPresentationLayer<UrlShortenApiResponse> {

	public static UrlShortenResponse of(long id, String urlHashCode, String url) {
		return new UrlShortenResponse(id, urlHashCode, url);
	}

	@Override
	public UrlShortenApiResponse toApiResponse() {
		return UrlShortenApiResponse.of(id, urlHashCode, url);
	}
}
