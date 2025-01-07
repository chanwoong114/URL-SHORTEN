package org.url.shorten.business.urlShorten.port;

import org.url.shorten.infrastructure.persistence.core.vo.UrlShortenVo;

public interface UrlShortenMapper {

    UrlShortenVo getUrlShortenById(long id);
}
