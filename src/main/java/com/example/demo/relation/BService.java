package com.example.demo.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BService {
    private final BRepository bRepository;

    public void read(Long idx){
        B b = bRepository.findById(idx).orElseThrow();
    }

    public void list(){
        List<B> aList = bRepository.findAll();
    }

    public void write(Long aIdx, BDto.BReq dto) {
        B b = dto.toEntity(aIdx);
        bRepository.save(b);
    }
}
