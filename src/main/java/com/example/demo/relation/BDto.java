package com.example.demo.relation;

import lombok.Getter;

public class BDto {
    @Getter
    public static class BReq{
        private String b01;
        private String b02;
//        private Long aIdx;

        public B toEntity(Long aIdx){
            return  B.builder()
                    .b01(this.getB01())
                    .b02(this.getB02())
                    .a(A.builder()
                            .idx(aIdx)
                            .build())
                    .build();
        }
    }
}
