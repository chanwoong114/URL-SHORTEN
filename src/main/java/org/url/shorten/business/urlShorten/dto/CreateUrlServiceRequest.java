package org.url.shorten.business.urlShorten.dto;

import org.url.shorten.application.urlShorten.dto.enums.UrlAlgorithmEnum;
import org.url.shorten.persistence.core.vo.UrlShortenVo;

public record CreateUrlServiceRequest(
	UrlAlgorithmEnum algorithm,
	String originalUrl
) {
	public static CreateUrlServiceRequest of(UrlAlgorithmEnum urlAlgorithmEnum,String originalUrl) {
		return new CreateUrlServiceRequest(urlAlgorithmEnum, originalUrl);
	}

	public UrlShortenVo toUrlShortenVo() {
		return UrlShortenVo.of(null, algorithm.getValue(), originalUrl);
	}
}
