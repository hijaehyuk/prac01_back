package com.example.demo.reply;

import com.example.demo.common.model.BaseResponse;
import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.model.AuthUserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reply")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

    @PostMapping("/reg/{board_idx}")
    public ResponseEntity register(
            @AuthenticationPrincipal AuthUserDetails user,
            @PathVariable Long board_idx,
            @RequestBody ReplyDto.RegReq dto){
        dto.setUser_idx(user.getIdx());
        dto.setBoard_idx(board_idx);
        ReplyDto.RegRes returnDto = replyService.saveReply(dto) ;
        return ResponseEntity.ok(returnDto);
    }
}
