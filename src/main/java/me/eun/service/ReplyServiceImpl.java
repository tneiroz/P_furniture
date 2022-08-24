package me.eun.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.eun.mapper.ReplyMapper;
import me.eun.model.ReplyDTO;

@Service
public class ReplyServiceImpl implements ReplyService {

	@Autowired
	private ReplyMapper replyMapper;
	
	/* 댓글등록 */
	@Override
	public int insertReply(ReplyDTO dto) {
		int result = replyMapper.insertReply(dto);
		return result;
	}

}
