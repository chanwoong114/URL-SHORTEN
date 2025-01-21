package org.url.shorten.application.urlShorten.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.url.shorten.application.urlShorten.dto.CreateUrlApiResponse;
import org.url.shorten.application.urlShorten.dto.CreateUrlRequest;
import org.url.shorten.application.urlShorten.dto.SelectUrlApiResponse;
import org.url.shorten.application.urlShorten.dto.SelectUrlRequest;
import org.url.shorten.application.urlShorten.port.UrlShortenService;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class UrlShortenController {

    private final UrlShortenService urlShortenService;

    @GetMapping("/{algorithmNumber}/{encodedId}")
    public RedirectView getUrl(@ModelAttribute @Valid SelectUrlRequest request) {

        SelectUrlApiResponse response = urlShortenService.selectUrl(request.toServiceRequest()).toApiResponse();
        return new RedirectView(response.originalUrl());
    }

    @PostMapping("/shorten")
    public String ShortenUrl(@RequestBody @Valid CreateUrlRequest request) {

        CreateUrlApiResponse response = urlShortenService.createUrl(request.toSelectServiceRequest()).toApiResponse();
        return response.toUrl();

    }
}
