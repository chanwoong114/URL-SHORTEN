package org.url.shorten.infrastructure.persistence.mapperAdapter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.url.shorten.business.urlShorten.port.UrlShortenMapper;
import org.url.shorten.infrastructure.persistence.core.entity.UrlShorten;
import org.url.shorten.infrastructure.persistence.core.vo.UrlShortenVo;
import org.url.shorten.infrastructure.persistence.jpaRepository.UrlShortenOrmMapper;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UrlShortenMapperImpl implements UrlShortenMapper {

    private final UrlShortenOrmMapper urlShortenOrmMapper;

    @Override
    public UrlShortenVo getUrlShortenById(long id) {
        Optional<UrlShorten> optionalUrlShorten = urlShortenOrmMapper.findById(id);
        UrlShorten urlShorten = optionalUrlShorten.orElseThrow(() -> new RuntimeException("찾고자 하는 url id에 해당하는 url이 없습니다."));
        return urlShorten.toUrlShortenVo();
    }
}
