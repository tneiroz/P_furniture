package me.eun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.eun.model.ReplyDTO;
import me.eun.service.ReplyService;

@RestController
@RequestMapping("/reply")
public class ReplyController {

	@Autowired 
	private ReplyService replyService;
	
	/* 댓글 등록 */
	@PostMapping("/new")
	public void insertReply(ReplyDTO dto) {
		replyService.insertReply(dto);
	}
}
