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
            team.setName("TeamA");
            em.persist(team);

            Member member = new Member();
            member.setName("MemberA");

            // 영속성 컨텍스트에 올라가기 전이든 올라가고 나서든
            // 위치는 상관 없는 것 같다 ? 내일 질문
            member.addTeam(team);
            em.persist(member);

            // 연관관계 편의 메서드 사용
            member.addTeam(team);

            Team findTeam = em.find(Team.class, team.getId());
            List<Member> members = findTeam.getMembers();

            System.out.println("======================");
            for (Member m : members) {
                System.out.println("m.getName() = " + m.getName());
            }
            System.out.println("Team 내부 Member 는? : " + findTeam.getMembers().get(0));
            System.out.println("======================");
            
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
