package jpa.jpashop.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class Member2 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Long teamId;
}

