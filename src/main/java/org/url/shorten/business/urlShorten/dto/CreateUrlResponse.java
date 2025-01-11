package org.url.shorten.business.urlShorten.dto;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.url.shorten.application.urlShorten.dto.CreateUrlApiResponse;
import org.url.shorten.application.urlShorten.dto.enums.UrlAlgorithmEnum;
import org.url.shorten.util.ConvertDtoByPresentationLayer;
import org.url.shorten.util.UrlAlgorithm;

public record CreateUrlResponse(
	Long id,
	int urlEncodingType
) implements ConvertDtoByPresentationLayer<CreateUrlApiResponse> {

	private static final Logger log = LoggerFactory.getLogger(CreateUrlResponse.class);

	public static CreateUrlResponse of(Long id, int urlEncodingType) {
		return new CreateUrlResponse(id, urlEncodingType);
	}

	public String encoding() {
		UrlAlgorithm urlAlgorithm = UrlAlgorithmEnum.fromValue(urlEncodingType).getUrlAlgorithm();
		log.info("url algorithm: {}", urlAlgorithm);
		log.info("url algorithm result: {}", urlAlgorithm.encode(id));
		return urlAlgorithm.encode(id);
	}

	@Override
	public CreateUrlApiResponse toApiResponse() {
		return CreateUrlApiResponse.of(urlEncodingType, encoding());
	}

}
