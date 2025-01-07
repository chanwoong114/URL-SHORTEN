package org.url.shorten.infrastructure.persistence.core.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.url.shorten.infrastructure.persistence.core.vo.UrlShortenVo;

@Data
@Entity
public class UrlShorten {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String urlHashCode;
    private String url;

    // salt 추가?
    // 알고리즘 사용시 알고리즘 넘버?

    public UrlShortenVo toUrlShortenVo() {
        return new UrlShortenVo(id, urlHashCode, url);
    }
}
