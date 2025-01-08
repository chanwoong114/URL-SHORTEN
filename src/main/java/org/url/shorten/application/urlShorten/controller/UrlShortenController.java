package org.url.shorten.application.urlShorten.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.url.shorten.application.urlShorten.dto.UrlShortenApiResponse;
import org.url.shorten.application.urlShorten.port.UrlShortenService;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class UrlShortenController {

    private final UrlShortenService urlShortenService;

    @GetMapping("/{id}")
    public UrlShortenApiResponse getUrl(@PathVariable Long id) {
        return urlShortenService.shortenUrl(id);
    }
}
