package com.hwan.yaksa.service;


import com.hwan.yaksa.domain.Member;
import com.hwan.yaksa.domain.Session;
import com.hwan.yaksa.dto.JoinDTO;
import com.hwan.yaksa.dto.LoginDTO;
import com.hwan.yaksa.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public void createMember(JoinDTO joinDTO){
        Member member=new Member();
        member.setId(joinDTO.getLogin_id());
        member.setPassword(joinDTO.getPassword());
        member.setName(joinDTO.getName());
        member.setAge(joinDTO.getAge());
        member.setRole(joinDTO.getRole());
        member.setCreateDateTime(LocalDateTime.now());
        memberRepository.create(member);
    }

    public int checkLogin(LoginDTO loginDTO){
        Member member = memberRepository.find(loginDTO.getLogin_id());
        if(member==null){
            return -2;
        }
        else{
            if (member.getPassword().equals(loginDTO.getPassword())) {
                return 0;
            }
            else{
                return -1;
            }
        }
    }

    public boolean findSession(Long sessionId){
        Session session=memberRepository.findSession(sessionId);
        if(session==null){
            return false;
        }
        else{
            return true;
        }
    }

    public Long createSession(LoginDTO loginDTO){
        Member member=memberRepository.find(loginDTO.getLogin_id());
        return memberRepository.createSession(member);
    }

    public void DeleteSession(Long sessionID){
        memberRepository.deleteSession(sessionID);
    }

}
