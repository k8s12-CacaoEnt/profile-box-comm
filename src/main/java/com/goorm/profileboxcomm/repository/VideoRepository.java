package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VideoRepository extends JpaRepository<Video, Long> {

    void deleteByVideoId(@Param("videoId") Long videoId);
}
