package com.example.demo.relation;

import com.example.demo.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/a")
public class AController {
    private final AService aService;

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx){
        aService.read(idx);
        return ResponseEntity.ok(
                BaseResponse.success("A 단건 조회")
        );
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        aService.list();
        return ResponseEntity.ok(
                BaseResponse.success("A 목록 조회")
        );
    }
}
