package org.url.shorten.persistence.core.entity;

import org.url.shorten.persistence.core.vo.UrlShortenVo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class UrlShorten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private int urlEncodingType;
    private String originalUrl;

    public static UrlShorten of(Long id, int urlEncodingType, String originalUrl) {
        return new UrlShorten(id, urlEncodingType, originalUrl);
    }

    public UrlShortenVo toUrlShortenVo() {
        return UrlShortenVo.of(id, urlEncodingType, originalUrl);
    }
}
