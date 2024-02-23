package com.workintech.JavaSpringRestApi.service;

import com.workintech.JavaSpringRestApi.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MemberService implements UserDetailsService {
    private MemberRepository memberRepository;
    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return memberRepository.findByEmail(email).orElseThrow(() -> {
            System.out.println("user credentials is not valid");
            throw new UsernameNotFoundException("user credentials is not valid");
        });
    }
}
