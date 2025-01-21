package org.url.shorten.business.urlShorten.serviceAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.url.shorten.application.urlShorten.port.UrlShortenService;
import org.url.shorten.business.urlShorten.dto.CreateUrlResponse;
import org.url.shorten.business.urlShorten.dto.CreateUrlServiceRequest;
import org.url.shorten.business.urlShorten.dto.SelectUrlResponse;
import org.url.shorten.business.urlShorten.dto.SelectUrlServiceRequest;
import org.url.shorten.business.urlShorten.port.UrlShortenMapper;
import org.url.shorten.persistence.core.vo.UrlShortenVo;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UrlShortenServiceImpl implements UrlShortenService {

    private final UrlShortenMapper urlShortenMapper;


    @Override
    public SelectUrlResponse selectUrl(SelectUrlServiceRequest request) {

        long id = request.decodingId();

        UrlShortenVo urlShortenVo = urlShortenMapper.getUrlShortenById(id);
        return urlShortenVo.toSelectServiceRequest();
    }

    @Override
    public CreateUrlResponse createUrl(CreateUrlServiceRequest request) {
        Optional<UrlShortenVo> urlShortenVoOptional = urlShortenMapper.getUrlShortenByEncodingTypeAndOriginalUrl(
                request.algorithm().getValue(),
                request.originalUrl());

        if (urlShortenVoOptional.isPresent()) {
            return urlShortenVoOptional.get().toCreateServiceRequest();
        }


        UrlShortenVo urlShortenVo = urlShortenMapper.saveUrl(request.toUrlShortenVo());
        return urlShortenVo.toCreateServiceRequest();
    }

}
