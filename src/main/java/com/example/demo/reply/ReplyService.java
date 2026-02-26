package com.example.demo.reply;

import com.example.demo.board.BoardRepository;
import com.example.demo.board.model.Board;
import com.example.demo.reply.model.Reply;
import com.example.demo.reply.model.ReplyDto;
import com.example.demo.user.UserRepository;
import com.example.demo.user.model.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReplyService {
    private final ReplyRepository replyRepository;
    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public ReplyDto.RegRes saveReply(ReplyDto.RegReq dto) {
        User user = userRepository.findById(dto.getUser_idx()).orElseThrow();
        Board board = boardRepository.findById(dto.getBoard_idx()).orElseThrow();

        Reply reply = dto.toEntity(user, board);

        Reply entity = replyRepository.save(reply);
        return ReplyDto.RegRes.from(entity);
    }
}
