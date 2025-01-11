package org.url.shorten.application.urlShorten.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;
import org.url.shorten.application.urlShorten.dto.CreateUrlApiResponse;
import org.url.shorten.application.urlShorten.dto.SelectUrlRequest;
import org.url.shorten.application.urlShorten.dto.CreateUrlRequest;
import org.url.shorten.application.urlShorten.port.UrlShortenService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class UrlShortenController {

    private final UrlShortenService urlShortenService;

    @GetMapping("/{algorithmNumber}/{encodedId}")
    public RedirectView getUrl(@ModelAttribute @Valid SelectUrlRequest request) {
        return new RedirectView(urlShortenService.selectUrl(request.toServiceRequest()).originalUrl());
    }

    @PostMapping("/shorten")
    public String ShortenUrl(@RequestBody @Valid CreateUrlRequest request) {

        CreateUrlApiResponse response = urlShortenService.createUrl(request.toSelectServiceRequest());
        return response.toUrl();

    }
}
