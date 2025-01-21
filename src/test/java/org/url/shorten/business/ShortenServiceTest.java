package org.url.shorten.business;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.url.shorten.application.urlShorten.dto.enums.UrlAlgorithmEnum;
import org.url.shorten.business.urlShorten.dto.CreateUrlResponse;
import org.url.shorten.business.urlShorten.dto.CreateUrlServiceRequest;
import org.url.shorten.business.urlShorten.dto.SelectUrlResponse;
import org.url.shorten.business.urlShorten.dto.SelectUrlServiceRequest;
import org.url.shorten.business.urlShorten.port.UrlShortenMapper;
import org.url.shorten.business.urlShorten.serviceAdapter.UrlShortenServiceImpl;
import org.url.shorten.persistence.core.vo.UrlShortenVo;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class ShortenServiceTest {

    @Mock
    private UrlShortenMapper urlShortenMapper;

    private UrlShortenServiceImpl urlShortenService;

    @BeforeEach
    void setUp() {
        // mock 객체 초기화
        MockitoAnnotations.openMocks(this);
        urlShortenService = new UrlShortenServiceImpl(urlShortenMapper);
    }

    @Test
    void testSelectUrl_Success() {
        // given
        long testId = 1L;
        UrlShortenVo mockVo = mock(UrlShortenVo.class);
        SelectUrlResponse mockResponse = mock(SelectUrlResponse.class);
        SelectUrlServiceRequest mockRequest = mock(SelectUrlServiceRequest.class);

        when(urlShortenMapper.getUrlShortenById(testId)).thenReturn(mockVo);
        when(mockVo.toSelectServiceRequest()).thenReturn(mockResponse);
        when(mockRequest.decodingId()).thenReturn(testId);

        // when
        SelectUrlResponse result = urlShortenService.selectUrl(mockRequest);

        // then
        assertNotNull(result);
         verify(urlShortenMapper).getUrlShortenById(testId);
    }


    @Test
    void testSelectUrl_InvalidInput() {
        // given
        long invalidId = 1L;
        SelectUrlServiceRequest mockRequest = mock(SelectUrlServiceRequest.class);
        when(mockRequest.decodingId()).thenReturn(invalidId);
        when(urlShortenMapper.getUrlShortenById(invalidId)).thenThrow(new RuntimeException("찾고자 하는 url id에 해당하는 url이 없습니다."));


        // when
        assertThrows(RuntimeException.class, () -> {
            urlShortenService.selectUrl(mockRequest);
        });

        // then
        verify(urlShortenMapper).getUrlShortenById(invalidId);
    }

    @Test
    void testCreateUrl_Success() {
        // given
        CreateUrlServiceRequest mockRequest = mock(CreateUrlServiceRequest.class);
        CreateUrlResponse mockResponse = mock(CreateUrlResponse.class);
        UrlAlgorithmEnum enumMock = mock(UrlAlgorithmEnum.class);
        UrlShortenVo mockVo = mock(UrlShortenVo.class);
        when(mockRequest.algorithm()).thenReturn(enumMock);
        when(enumMock.getValue()).thenReturn(1);
        when(mockRequest.originalUrl()).thenReturn("https://www.google.com");
        when(mockRequest.toUrlShortenVo()).thenReturn(mockVo);
        when(mockVo.toCreateServiceRequest()).thenReturn(mockResponse);
        when(urlShortenMapper.getUrlShortenByEncodingTypeAndOriginalUrl(1, "https://www.google.com"))
                .thenReturn(Optional.empty());
        when(urlShortenMapper.saveUrl(mockVo)).thenReturn(mockVo);

        // when
        CreateUrlResponse createUrlResponse = urlShortenService.createUrl(mockRequest);

        assertNotNull(createUrlResponse);
        verify(urlShortenMapper).getUrlShortenByEncodingTypeAndOriginalUrl(1, "https://www.google.com");
        verify(urlShortenMapper).saveUrl(mockVo);
    }
}
