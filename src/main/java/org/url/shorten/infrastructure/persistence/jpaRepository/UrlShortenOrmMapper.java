package org.url.shorten.infrastructure.persistence.jpaRepository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.url.shorten.infrastructure.persistence.core.entity.UrlShorten;

import java.util.Optional;

public interface UrlShortenOrmMapper extends JpaRepository<UrlShorten, Long> {

    Optional<UrlShorten> findById(long id);
}
