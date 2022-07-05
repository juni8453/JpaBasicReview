package jpa.jpashop.exdomain;

import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;
    private String city;
    private String street;
    private String zipcode;

    /*
    * 사실 Member 에서 어떤 주문들을 했는지에 대해선 그닥 중요하지 않다.
    * 이미 Order 에서 Member 의 PK 값을 FK 로 가지고 있기 때문에, Member 에서 굳이 Order List 를 조회할 필요가 없다.
    * 즉, 관심사를 끊어낼 땐 끊어내는 것이 좋은데, 지금은 예제니까 !
    * */
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
