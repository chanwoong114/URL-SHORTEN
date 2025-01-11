package org.url.shorten.business.urlShorten.serviceAdapter;

import org.springframework.stereotype.Service;
import org.url.shorten.application.urlShorten.dto.CreateUrlApiResponse;
import org.url.shorten.application.urlShorten.dto.SelectUrlApiResponse;
import org.url.shorten.application.urlShorten.port.UrlShortenService;
import org.url.shorten.business.urlShorten.dto.CreateUrlResponse;
import org.url.shorten.business.urlShorten.dto.CreateUrlServiceRequest;
import org.url.shorten.business.urlShorten.dto.SelectUrlServiceRequest;
import org.url.shorten.business.urlShorten.dto.SelectUrlResponse;
import org.url.shorten.business.urlShorten.port.UrlShortenMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UrlShortenServiceImpl implements UrlShortenService {

    private final UrlShortenMapper urlShortenMapper;


    @Override
    public SelectUrlApiResponse selectUrl(SelectUrlServiceRequest request) {

        long id = request.decodingId();

        SelectUrlResponse selectUrlResponse = urlShortenMapper.getUrlShortenById(id);
        return selectUrlResponse.toApiResponse();
    }

    @Override
    public CreateUrlApiResponse createUrl(CreateUrlServiceRequest request) {

        CreateUrlResponse createUrlResponse = urlShortenMapper.saveUrl(request.toUrlShortenVo());
        return createUrlResponse.toApiResponse();
    }

}
