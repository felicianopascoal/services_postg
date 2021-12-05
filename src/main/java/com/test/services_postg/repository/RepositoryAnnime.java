package com.test.services_postg.repository;

import com.test.services_postg.domain.Annime;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepositoryAnnime extends JpaRepository<Annime, Long> {

}
