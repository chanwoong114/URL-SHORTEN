package org.url.shorten.persistence.mapperAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
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
    public UrlShortenVo getUrlShortenById(long id) {
        Optional<UrlShortenVo> optionalUrlShorten = urlShortenOrmMapper.findById(id);
        return optionalUrlShorten.orElseThrow(() -> new RuntimeException("찾고자 하는 url id에 해당하는 url이 없습니다."));
    }

    @Override
    public Optional<UrlShortenVo> getUrlShortenByEncodingTypeAndOriginalUrl(int encodingType, String originalUrl) {
        return urlShortenOrmMapper.findByUrlEncodingTypeAndOriginalUrl(encodingType, originalUrl);
    }

    @Override
    public UrlShortenVo saveUrl(UrlShortenVo urlShortenVo) {
        UrlShorten urlShorten = urlShortenOrmMapper.save(urlShortenVo.toEntity());

        return urlShorten.toUrlShortenVo();
    }
}
