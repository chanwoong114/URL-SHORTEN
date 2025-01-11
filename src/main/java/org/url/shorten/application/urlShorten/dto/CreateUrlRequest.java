package org.url.shorten.application.urlShorten.dto;

import org.url.shorten.application.urlShorten.dto.enums.UrlAlgorithmEnum;
import org.url.shorten.business.urlShorten.dto.CreateUrlServiceRequest;
import org.url.shorten.util.ConvertDtoByBusinessLayer;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public record CreateUrlRequest(
	@Min(1)
	@Max(2)
	Integer algorithmNumber,

	@NotBlank(message = "{field.notNull}")
	String originalUrl
) implements ConvertDtoByBusinessLayer<CreateUrlServiceRequest> {

	@Override
	public CreateUrlServiceRequest toSelectServiceRequest() {
		return CreateUrlServiceRequest.of(UrlAlgorithmEnum.fromValue(algorithmNumber), originalUrl);
	}
}
