package jpa.jpashop;

import jpa.jpashop.domain.Member;
import jpa.jpashop.domain.Team;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Team team = new Team();
            team.setName("teamB");
            em.persist(team);

            Member member = new Member();
            member.setName("memberB");

            // 연관관계가 존재하는 객체는 JPA 가 자동으로 PK 값을 꺼내서 연관관계의 주인 쪽 FK 값으로 사용
            member.setTeam(team);
            em.persist(member);
            
            em.flush();
            em.clear();



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
