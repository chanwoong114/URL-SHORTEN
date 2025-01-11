package org.url.shorten.persistence.mapperAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.url.shorten.business.urlShorten.dto.CreateUrlResponse;
import org.url.shorten.business.urlShorten.dto.SelectUrlResponse;
import org.url.shorten.business.urlShorten.port.UrlShortenMapper;
import org.url.shorten.persistence.core.entity.UrlShorten;
import org.url.shorten.persistence.core.vo.UrlShortenVo;
import org.url.shorten.persistence.jpaRepository.UrlShortenOrmMapper;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UrlShortenMapperImpl implements UrlShortenMapper {

    private final UrlShortenOrmMapper urlShortenOrmMapper;

    @Override
    public SelectUrlResponse getUrlShortenById(long id) {
        Optional<UrlShortenVo> optionalUrlShorten = urlShortenOrmMapper.findById(id);
        UrlShortenVo urlShorten = optionalUrlShorten.orElseThrow(() -> new RuntimeException("찾고자 하는 url id에 해당하는 url이 없습니다."));
        return urlShorten.toSelectServiceRequest();
    }

    @Override
    public CreateUrlResponse saveUrl(UrlShortenVo urlShortenVo) {
        Optional<UrlShortenVo> optionalUrlShorten = urlShortenOrmMapper.findByUrlEncodingTypeAndOriginalUrl(
            urlShortenVo.urlEncodingType(),
            urlShortenVo.originalUrl());

        if (optionalUrlShorten.isPresent()) {
            return optionalUrlShorten.get().toCreateServiceRequest();
        }

        UrlShorten urlShorten = urlShortenOrmMapper.save(urlShortenVo.toEntity());

        return urlShorten.toUrlShortenVo().toCreateServiceRequest();
    }
}
