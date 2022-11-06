package me.eun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import me.eun.model.Board;
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
	
	/* 댓글 체크 */
	@PostMapping("/check")
	public String replyCheckPOST(ReplyDTO dto) {
		return replyService.checkReply(dto);
	}
	
	/*댓글 목록*/
	//@GetMapping(value="/list", produces = MediaType.APPLICATION_JSON_VALUE)
	//public ResponseEntity<List<ReplyDTO>>get(@PathVariable Long rno){
	//	return new ResponseEntity<List<ReplyDTO>>(replyService.getReplyList(rno),HttpStatus.OK);
	//}
    
	
	/*댓글 목록*/
//	/@GetMapping("/list")
	//public String replyList(Long bno, Model model) {
	//	List<ReplyDTO> list = replyService.getReplyList(bno);
//		
//		model.addAttribute("replyList", list);
		
//		return "board/list";
//	}
    
}
