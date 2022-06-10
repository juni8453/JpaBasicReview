package hellojpa;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class Member {

    @Id
    private Long id;

    // 만약 DB 의 컬럼명이 username 이라면, 이렇게 컬럼명을 지정할 수도 있음.
    // @Column(name = "username")
    private String name;
}
