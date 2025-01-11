package org.url.shorten.business.urlShorten.dto;

import org.url.shorten.util.UrlAlgorithm;

public record SelectUrlServiceRequest(
	UrlAlgorithm urlAlgorithm,
	String encodedId
) {

	public static SelectUrlServiceRequest of(UrlAlgorithm urlAlgorithm, String encodedId) {
		return new SelectUrlServiceRequest(urlAlgorithm, encodedId);
	}

	public long decodingId() {
		return urlAlgorithm.decode(encodedId);
	}


}
