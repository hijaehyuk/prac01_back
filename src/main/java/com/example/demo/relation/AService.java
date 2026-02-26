package com.example.demo.relation;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AService {
    private final ARepository aRepository;

    public void read(Long idx){
        A a = aRepository.findById(idx).orElseThrow();
    }

    public void list(){
        List<A> aList = aRepository.findAll();
    }
}
