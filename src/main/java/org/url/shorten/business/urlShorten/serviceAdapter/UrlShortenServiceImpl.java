package org.url.shorten.business.urlShorten.serviceAdapter;

import java.util.Objects;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.url.shorten.application.urlShorten.dto.UrlShortenApiResponse;
import org.url.shorten.application.urlShorten.port.UrlShortenService;
import org.url.shorten.business.urlShorten.dto.UrlShortenResponse;
import org.url.shorten.business.urlShorten.port.UrlShortenMapper;

@Service
@RequiredArgsConstructor
public class UrlShortenServiceImpl implements UrlShortenService {

    private final UrlShortenMapper urlShortenMapper;


    @Override
    public UrlShortenApiResponse shortenUrl(Long id) {
        if (Objects.isNull(id)) {
            throw new IllegalArgumentException("id is null");
        }

        UrlShortenResponse urlShortenResponse = urlShortenMapper.getUrlShortenById(id);
        return urlShortenResponse.toApiResponse();
    }
}
