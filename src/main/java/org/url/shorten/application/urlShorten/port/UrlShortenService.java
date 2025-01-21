package org.url.shorten.application.urlShorten.port;

import org.url.shorten.business.urlShorten.dto.CreateUrlResponse;
import org.url.shorten.business.urlShorten.dto.CreateUrlServiceRequest;
import org.url.shorten.business.urlShorten.dto.SelectUrlResponse;
import org.url.shorten.business.urlShorten.dto.SelectUrlServiceRequest;

public interface UrlShortenService {

    SelectUrlResponse selectUrl(SelectUrlServiceRequest request);

    CreateUrlResponse createUrl(CreateUrlServiceRequest request);
}
