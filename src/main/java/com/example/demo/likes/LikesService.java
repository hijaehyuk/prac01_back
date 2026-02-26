package com.example.demo.likes;

import com.example.demo.board.model.Board;
import com.example.demo.likes.model.Likes;
import com.example.demo.likes.model.LikesDto;
import com.example.demo.user.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikesService {
    private final LikesRepository likesRepository;

    public void like(Long user_idx, Long board_idx){
        Likes entity = Likes.builder()
                .user(User.builder().idx(user_idx).build())
                .board(Board.builder().idx(board_idx).build())
                .build();
        likesRepository.save(entity);
    }
}
