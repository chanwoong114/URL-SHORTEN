package org.url.shorten.application.urlShorten.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.url.shorten.application.urlShorten.port.UrlShortenService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class UrlShortenController {

    private final UrlShortenService urlShortenService;

    @GetMapping("/{id}")
    public String getUrl(@PathVariable long id) {
        return urlShortenService.shortenUrl(id);
    }

}
