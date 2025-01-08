package org.url.shorten.persistence.core.vo;

import org.url.shorten.business.urlShorten.dto.UrlShortenResponse;
import org.url.shorten.util.ConvertDtoByBusinessLayer;

public record UrlShortenVo(
    long id,
    String urlHashCode,
    String url
) implements ConvertDtoByBusinessLayer<UrlShortenResponse> {

	public static UrlShortenVo of(final long id, final String url, final String urlHashCode) {
		return new UrlShortenVo(id, urlHashCode,url);
	}

	@Override
	public UrlShortenResponse toServiceRequest() {
		return UrlShortenResponse.of(id, urlHashCode, url);
	}
}
