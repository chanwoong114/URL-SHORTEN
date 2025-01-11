package org.url.shorten.persistence.core.vo;

import org.url.shorten.business.urlShorten.dto.CreateUrlResponse;
import org.url.shorten.business.urlShorten.dto.SelectUrlResponse;
import org.url.shorten.persistence.core.entity.UrlShorten;

public record UrlShortenVo(
    Long id,
    int urlEncodingType,
    String originalUrl
) {

	public static UrlShortenVo of(Long id, int urlEncodingType, String originalUrl) {
		return new UrlShortenVo(id, urlEncodingType, originalUrl);
	}

	public UrlShorten toEntity() {
		return UrlShorten.of(id, urlEncodingType, originalUrl);
	}

	public SelectUrlResponse toSelectServiceRequest() {
		return SelectUrlResponse.of(id, urlEncodingType, originalUrl);
	}

	public CreateUrlResponse toCreateServiceRequest() {
		return CreateUrlResponse.of(id, urlEncodingType);
	}
}
