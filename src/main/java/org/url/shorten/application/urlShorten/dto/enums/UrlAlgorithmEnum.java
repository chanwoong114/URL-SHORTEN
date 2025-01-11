package org.url.shorten.application.urlShorten.dto.enums;

import org.url.shorten.util.CustomBase62;
import org.url.shorten.util.CustomBase64;
import org.url.shorten.util.UrlAlgorithm;

import lombok.Getter;

@Getter
public enum UrlAlgorithmEnum {
	BASE62(1),
	BASE64(2);

	private final int value;

	UrlAlgorithmEnum(int value) {
		this.value = value;
	}

	public static UrlAlgorithmEnum fromValue(int value) {
		for (UrlAlgorithmEnum algorithm : values()) {
			if (algorithm.value == value) {
				return algorithm;
			}
		}
		throw new IllegalArgumentException("Invalid algorithm value: " + value);
	}
	public UrlAlgorithm getUrlAlgorithm() {
		if (this == BASE62) {
			return new CustomBase62();
		}
		if (this == BASE64) {
			return new CustomBase64();
		}

		throw new IllegalArgumentException("Unsupported url algorithm: " + this);
	}
}
