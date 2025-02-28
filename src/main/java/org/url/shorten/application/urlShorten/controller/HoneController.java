package org.url.shorten.application.urlShorten.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class HoneController {

    @GetMapping("")
    public String home() {
        log.info("Home page");
        return "index";
    }
}
