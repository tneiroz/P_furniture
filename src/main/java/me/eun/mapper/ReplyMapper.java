package me.eun.mapper;

import java.util.List;

import me.eun.model.ReplyDTO;

public interface ReplyMapper {
	
	/* 댓글 등록 */
	public int insertReply (ReplyDTO dto);

	/* 댓글 존재 체크 */
	public Integer checkReply(ReplyDTO dto);
	
	/* 댓글 목록*/
	public List<ReplyDTO> getReplyList(Long bno);
}
