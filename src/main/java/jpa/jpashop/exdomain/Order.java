package jpa.jpashop.exdomain;

import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Table(name = "ORDERS")
@Entity
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;

    private LocalDateTime orderDate;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

}

