package jpa.jpashop.exdomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CategoryItem {

    @Id
    @GeneratedValue
    private Long id;
}
