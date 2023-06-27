package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Filmo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmoRepository extends JpaRepository<Filmo, Long> {
}
