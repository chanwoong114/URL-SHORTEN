package org.url.shorten.api;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.url.shorten.application.urlShorten.dto.CreateUrlRequest;

// @Disabled
public class MonitoringDashboardApiTest {

	private TestRestTemplate restTemplate;
	private HttpHeaders headers;

	private static final String DEV_ENVIRONMENT = "http://localhost:8080";
	private static final String CREATE_URL = DEV_ENVIRONMENT + "/shorten";
	private static final String SELECT_URL = DEV_ENVIRONMENT + "/check/template/name";

	@BeforeEach
	void setUp() {
		restTemplate = new TestRestTemplate();
		headers = new HttpHeaders();
		// headers.set("accessToken",
		// 	"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOiJjdy5sZWUiLCJzdWIiOiJhY2Nlc3NUb2tlbiJ9.5t0VogJXHSLNn67zQXZysnGICPZiNmdebR2KEwpMLqQ");
		// headers.set("userId", "cw.lee");
	}

	@Test
	@DisplayName("[Green] url을 전달받고 단축된 url 반환에 성공한다.")
	void createUrl() {
		// given
		CreateUrlRequest request = new CreateUrlRequest(1, "https://www.naver.com");
		HttpEntity<CreateUrlRequest> requestEntity = new HttpEntity<>(request, headers);

		// when
		String response = restTemplate.postForEntity(CREATE_URL, requestEntity,
			String.class).getBody();

		System.out.println(response);

		// then
		assertAll(
			() -> {
				assert response != null;
				assertThat(response.charAt(0)).isEqualTo('h');
			}
		);
	}
}
