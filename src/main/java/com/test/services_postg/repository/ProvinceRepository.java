package com.test.services_postg.repository;

import com.test.services_postg.domain.Province;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProvinceRepository extends JpaRepository<Province, Long> {
    Optional<Province> findByName(String nome);
    Optional<Province> findById(Long id);
}