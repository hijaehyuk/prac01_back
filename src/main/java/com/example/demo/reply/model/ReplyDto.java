package com.example.demo.reply.model;

import com.example.demo.board.model.Board;
import com.example.demo.board.model.BoardDto;
import com.example.demo.user.model.User;
import lombok.*;
import org.springframework.stereotype.Service;

public class ReplyDto {
    @Builder
    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RegReq {
        private String contents;
        @Setter
        private Long user_idx;
        @Setter
        private Long board_idx;

        public Reply toEntity(User user, Board board) {
            return Reply.builder()
                    .contents(this.contents)
                    .user(user)   // 외부에서 가져온 '진짜' 객체 사용
                    .board(board)
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String contents;
        private Long user_idx;
        private Long board_idx;

        public static ReplyDto.RegRes from(Reply entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .user_idx(entity.getUser().getIdx())
                    .board_idx(entity.getBoard().getIdx())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String contents;
        private String username;

        public static ReplyDto.ListRes from(Reply entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .contents(entity.getContents())
                    .username(entity.getUser().getName())
                    .build();
        }
    }
}
