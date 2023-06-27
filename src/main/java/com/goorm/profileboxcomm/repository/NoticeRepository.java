package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Notice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeRepository extends JpaRepository<Notice, Long> {
    Notice findByNoticeId(Long noticeId);
    void deleteByNoticeId(Long noticeId);
}
