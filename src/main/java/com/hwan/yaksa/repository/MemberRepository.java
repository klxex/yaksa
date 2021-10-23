package com.hwan.yaksa.repository;


import com.hwan.yaksa.domain.Member;
import com.hwan.yaksa.domain.Session;
import com.hwan.yaksa.dto.JoinDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;

@Repository
@RequiredArgsConstructor
@Transactional
public class MemberRepository {
    private final EntityManager em;

    public void create(Member member) {
        em.persist(member);
    }

    public Member find(String login_id) {
        return em.find(Member.class, login_id);
    }

    public Session findSession(Long sessionId){
        return em.find(Session.class, sessionId);
    }

    public void delete(String login_id) {
        Member member = em.find(Member.class, login_id);
        em.remove(member);
    }

    public void update() {
    }

    public Long createSession(Member member){
        Session session=new Session();
        session.setMember(member);
        em.persist(session);
        return session.getId();
    }

    public void deleteSession(Long sessionId){
        Session session=em.find(Session.class,sessionId);
        em.remove(session);
    }
}
