package org.url.shorten.business.urlShorten.serviceAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.url.shorten.application.urlShorten.port.UrlShortenService;
import org.url.shorten.business.urlShorten.port.UrlShortenMapper;
import org.url.shorten.infrastructure.persistence.core.vo.UrlShortenVo;

@Service
@RequiredArgsConstructor
public class UrlShortenServiceImpl implements UrlShortenService {

    private final UrlShortenMapper urlShortenMapper;


    @Override
    public String shortenUrl(long id) {
        UrlShortenVo urlShortenVo = urlShortenMapper.getUrlShortenById(id);
        return urlShortenVo.url();
    }
}
