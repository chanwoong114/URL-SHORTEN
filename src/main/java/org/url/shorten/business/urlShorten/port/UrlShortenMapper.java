package org.url.shorten.business.urlShorten.port;

import org.url.shorten.business.urlShorten.dto.CreateUrlResponse;
import org.url.shorten.business.urlShorten.dto.SelectUrlResponse;
import org.url.shorten.persistence.core.vo.UrlShortenVo;

public interface UrlShortenMapper {

    SelectUrlResponse getUrlShortenById(long id);

    CreateUrlResponse saveUrl(UrlShortenVo urlShortenVo);
}
