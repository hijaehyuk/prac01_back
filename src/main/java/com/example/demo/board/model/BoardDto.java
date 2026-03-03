package com.example.demo.board.model;

import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.model.User;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.data.domain.Page;

import java.util.List;

public class BoardDto {
    @Getter
    @Builder
    public static class PageRes {
        private List<ListRes> boardList;
        private int totalPage;
        private long totalCount;
        private int currentPage;
        private int currentSize;

        public static PageRes from(Page<Board> result) {
            return PageRes.builder()
                    .boardList(result.get().map(BoardDto.ListRes::from).toList())
                    .totalPage(result.getTotalPages())
                    .totalCount(result.getTotalElements())
                    .currentPage(result.getPageable().getPageNumber())
                    .currentSize(result.getPageable().getPageSize())
                    .build();
        }
    }

    @Getter
    public static class RegReq {
        @Schema(description = "제목은 50자글자까지만 입력 가능합니다.", required = true, example = "제목01")
        private String title;
        private String contents;
        @Setter
        private Long user_idx;

        public Board toEntity() {
            return Board.builder()
                    .title(this.title)
                    .contents(this.contents)
                    .user(User.builder().idx(this.user_idx).build())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class RegRes {
        private Long idx;
        private String title;
        private String contents;
        private Long user_idx;

        public static RegRes from(Board entity) {
            return RegRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .user_idx(entity.getUser().getIdx())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ListRes {
        private Long idx;
        private String title;
        private String username;
        private int count;

        public static ListRes from(Board entity) {
            return ListRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .username(entity.getUser().getName())
                    .count(entity.getReply().size())
                    .build();
        }
    }

    @Builder
    @Getter
    public static class ReadRes {
        private Long idx;
        private String title;
        private String contents;
        private String username;
        private List<ReplyDto.ListRes> replyList;

        public static ReadRes from(Board entity) {
            return ReadRes.builder()
                    .idx(entity.getIdx())
                    .title(entity.getTitle())
                    .contents(entity.getContents())
                    .username(entity.getUser().getName())
                    .replyList(entity.getReply().stream().map(ReplyDto.ListRes::from).toList())
                    .build();
        }
    }
}
