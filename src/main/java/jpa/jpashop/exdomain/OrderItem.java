package jpa.jpashop.exdomain;

import lombok.Getter;

import javax.persistence.*;

@Getter
@Entity
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    private int orderPrice;
    private int count;
}
