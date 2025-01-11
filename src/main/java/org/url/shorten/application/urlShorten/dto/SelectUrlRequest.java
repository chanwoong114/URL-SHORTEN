package org.url.shorten.application.urlShorten.dto;

import org.url.shorten.application.urlShorten.dto.enums.UrlAlgorithmEnum;
import org.url.shorten.business.urlShorten.dto.SelectUrlServiceRequest;
import org.url.shorten.util.UrlAlgorithm;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record SelectUrlRequest(
	@Min(1)
	@Max(2)	int algorithmNumber,

	@NotBlank
	String encodedId
) {

	public SelectUrlServiceRequest toServiceRequest() {
		UrlAlgorithm urlAlgorithm = UrlAlgorithmEnum.fromValue(algorithmNumber).getUrlAlgorithm();

		return new SelectUrlServiceRequest(urlAlgorithm, encodedId);
	}
}
