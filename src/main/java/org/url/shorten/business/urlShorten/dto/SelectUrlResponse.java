package org.url.shorten.business.urlShorten.dto;

import org.url.shorten.application.urlShorten.dto.SelectUrlApiResponse;
import org.url.shorten.util.ConvertDtoByPresentationLayer;

public record SelectUrlResponse(
	long id,
	int urlEncodingType,
	String originalUrl
) implements ConvertDtoByPresentationLayer<SelectUrlApiResponse> {

	public static SelectUrlResponse of(long id, int urlEncodingType, String originalUrl) {
		return new SelectUrlResponse(id, urlEncodingType, originalUrl);
	}

	@Override
	public SelectUrlApiResponse toApiResponse() {
		return SelectUrlApiResponse.of(id, urlEncodingType, originalUrl);
	}
}
