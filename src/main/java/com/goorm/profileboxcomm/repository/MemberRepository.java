package com.goorm.profileboxcomm.repository;

import com.goorm.profileboxcomm.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Boolean existsByMemberEmail(String email);
    Member findMemberByMemberEmailAndMemberPassword(String email, String password);
    Member findMemberByMemberId(Long memberId);
}
