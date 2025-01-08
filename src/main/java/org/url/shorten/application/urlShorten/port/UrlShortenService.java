package org.url.shorten.application.urlShorten.port;

import org.url.shorten.application.urlShorten.dto.UrlShortenApiResponse;

public interface UrlShortenService {

    UrlShortenApiResponse shortenUrl(Long id);
}
