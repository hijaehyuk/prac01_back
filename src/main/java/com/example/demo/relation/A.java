package com.example.demo.relation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class A {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String a01;

    // 관계의 주인이 누구인지 지정
    @OneToMany(mappedBy = "a")
    // 외래키 속성 지정
    private List<B> bList;
}
