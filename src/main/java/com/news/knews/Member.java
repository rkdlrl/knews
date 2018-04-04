package com.news.knews;

import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.List;

@Entity
public class Member {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private long seq;
    private String name;
    private int age;
    @OneToMany(mappedBy = "member") //테이블이 실제로 가지고 있는게 아니라 이미 매핑한 애를 알아서 함
    private List<ProductOrder> productOrders;

    public List<ProductOrder> getProductOrders() {
        return productOrders;
    }

    public void setProductOrders(List<ProductOrder> productOrders) {
        this.productOrders = productOrders;
    }

    public long getSeq() {
        return seq;
    }

    public void setSeq(long seq) {
        this.seq = seq;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
