package org.url.shorten.business.urlShorten.port;

import org.url.shorten.business.urlShorten.dto.UrlShortenResponse;

public interface UrlShortenMapper {

    UrlShortenResponse getUrlShortenById(long id);
}
