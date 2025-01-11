package org.url.shorten.persistence.jpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.url.shorten.persistence.core.entity.UrlShorten;
import org.url.shorten.persistence.core.vo.UrlShortenVo;

import java.util.Optional;

public interface UrlShortenOrmMapper extends JpaRepository<UrlShorten, Long> {

    @Query("select new org.url.shorten.persistence.core.vo.UrlShortenVo(a.id, a.urlEncodingType, a.originalUrl) "
     + "from UrlShorten a where a.id=:id")
    Optional<UrlShortenVo> findById(@Param("id") long id);


    @Query("select new org.url.shorten.persistence.core.vo.UrlShortenVo(a.id, a.urlEncodingType, a.originalUrl) "
        + "from UrlShorten a where a.urlEncodingType=:urlEncodingType and a.originalUrl=:originalUrl")
    Optional<UrlShortenVo> findByUrlEncodingTypeAndOriginalUrl(
        @Param("urlEncodingType")int urlEncodingType, @Param("originalUrl") String originalUrl);

}
