package com.example.demo.relation;

import com.example.demo.common.model.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/b")
public class BController {
    private final BService bService;

    @PostMapping("/reg/{aIdx}")
    public ResponseEntity reg(@PathVariable Long aIdx, @RequestBody BDto.BReq dto){
        bService.write(aIdx, dto);
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity read(@PathVariable Long idx){
        bService.read(idx);
        return ResponseEntity.ok(
                BaseResponse.success("B 단건 조회")
        );
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        bService.list();
        return ResponseEntity.ok(
                BaseResponse.success("B 목록 조회")
        );
    }
}
