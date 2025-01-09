package org.url.shorten.persistence.core.entity;

import org.url.shorten.persistence.core.vo.UrlShortenVo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

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
        return UrlShortenVo.of(id, urlHashCode, url);
    }
}
