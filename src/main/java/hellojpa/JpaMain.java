package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member memberA = new Member(150L, "A");
            Member findMember150 = em.find(Member.class, 150L);
            findMember150.setName("changeName150");

            // 영속 컨텍스트가 flush() 되는 시점에 스냅샷과 엔티티의 현재 상태를 비교한다.
            // 비교해서 달라진 Entity 를 찾고, 달라진게 있다면 자동으로 UPDATE 쿼리가 생성된다.
            // 생성된 UPDATE 쿼리는 영속 컨텍스트의 쓰기 지연 SQL 저장소에 담긴다.
            // 이제 트랜잭션을 commit() 하게되면 담겨있던 UPDATE 가 실행되며 (flush) 엔티티 수정 값이 DB에 반영된다.
            tx.commit();

        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
