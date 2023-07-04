package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Filmo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmoRepository extends JpaRepository<Filmo, Long> {

    void deleteByFilmoId(@Param("filmoId") Long filmoId);
}
