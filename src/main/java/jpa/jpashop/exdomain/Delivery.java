package jpa.jpashop.exdomain;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@Entity
public class Delivery {

    @Id
    @GeneratedValue
    private Long id;

    private String street;
    private String zipcode;
}
