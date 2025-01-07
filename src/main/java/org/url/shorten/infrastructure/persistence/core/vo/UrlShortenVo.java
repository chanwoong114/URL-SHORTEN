package org.url.shorten.infrastructure.persistence.core.vo;

public record UrlShortenVo(
    long id,
    String urlHashCode,
    String url
) {
}
