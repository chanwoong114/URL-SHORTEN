package org.url.shorten.business.urlShorten.port;

import org.url.shorten.persistence.core.vo.UrlShortenVo;

import java.util.Optional;

public interface UrlShortenMapper {

    UrlShortenVo getUrlShortenById(long id);

    Optional<UrlShortenVo> getUrlShortenByEncodingTypeAndOriginalUrl(int encodingType, String originalUrl);

    UrlShortenVo saveUrl(UrlShortenVo urlShortenVo);
}
