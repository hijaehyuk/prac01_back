package com.example.demo.likes;

import com.example.demo.likes.model.LikesDto;
import com.example.demo.user.model.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/like")
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    @GetMapping("/reg/{board_idx}")
    public ResponseEntity like(@AuthenticationPrincipal AuthUserDetails user,
                               @PathVariable Long board_idx){
        likesService.like(user.getIdx(), board_idx);
        return ResponseEntity.ok("댓글 성공");
    }
}
