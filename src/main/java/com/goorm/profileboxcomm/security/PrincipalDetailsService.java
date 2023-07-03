package com.goorm.profileboxcomm.security;

import com.goorm.profileboxcomm.entity.Member;
import com.goorm.profileboxcomm.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Member member = memberRepository.findMemberByMemberEmail(email);
        if (member == null) {
            throw new UsernameNotFoundException("Member not found with email: " + email);
        }
        return new PrincipalDetails(member);
    }


}
