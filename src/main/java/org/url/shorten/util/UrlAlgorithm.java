package org.url.shorten.util;

public interface UrlAlgorithm {

	String encode(long urlId);

	long decode(String encodedUrlId);
}
