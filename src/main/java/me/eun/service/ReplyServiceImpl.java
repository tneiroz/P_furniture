package me.eun.service;

import java.util.List;

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
	/*댓글 존재 체크 */
	@Override
	public String checkReply(ReplyDTO dto) {
		Integer result = replyMapper.checkReply(dto);
		
		if(result == null) {
			return "0";
		} else {
			return "1";
		}
	}	
	/* 댓글 목록*/
	@Override
	public List<ReplyDTO> getReplyList(Long bno) {
		return replyMapper.getReplyList(bno);
	}
	
	
}
