package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {

    void deleteByImageId(@Param("imageId") Long imageId);
}
