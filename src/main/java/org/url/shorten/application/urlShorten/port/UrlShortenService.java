package org.url.shorten.application.urlShorten.port;

import org.url.shorten.application.urlShorten.dto.CreateUrlApiResponse;
import org.url.shorten.application.urlShorten.dto.SelectUrlApiResponse;
import org.url.shorten.business.urlShorten.dto.CreateUrlServiceRequest;
import org.url.shorten.business.urlShorten.dto.SelectUrlServiceRequest;

public interface UrlShortenService {

    SelectUrlApiResponse selectUrl(SelectUrlServiceRequest request);

    CreateUrlApiResponse createUrl(CreateUrlServiceRequest request);
}
