package me.eun.service;

import me.eun.model.ReplyDTO;

public interface ReplyService {


	/* 댓글 등록 */
	public int insertReply(ReplyDTO dto);
}
