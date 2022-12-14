package me.eun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import me.eun.model.Board;
import me.eun.model.Criteria;
import me.eun.model.PageMarker;
import me.eun.model.ReplyDTO;
import me.eun.service.BoardService;
import me.eun.service.ReplyService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService service;
	
	@Autowired
	private ReplyService replyService;


	@GetMapping("/list")
	public String boarList(Model model , Criteria criteria) {
		PageMarker pageMarker = new PageMarker(criteria, service.totalCount());
		pageMarker.setCriteria(criteria);
		model.addAttribute("list", service.getList(criteria));
		model.addAttribute("pageMaker",pageMarker);
		return "board/list";
	}
	
	@GetMapping("/get")
	public String get(Long bno, Model model) {
		List<ReplyDTO> list = replyService.getReplyList(bno);
		
		model.addAttribute("replyList", list);
		
		model.addAttribute("board",service.get(bno));
		
		return "board/get";
	}
	
	@GetMapping("/modify")
	public String modifyForm(Long bno, Model model) {
		model.addAttribute("board",service.get(bno));
		return "board/modify";
	}
	@PostMapping("/modify")
	public String modify(Board board , RedirectAttributes rttr) {	
		service.modify(board);
		rttr.addFlashAttribute("result","modify");
		rttr.addFlashAttribute("bno",board.getBno());
		return "redirect:list";
	}
	@GetMapping("/register")
	public String registerForm() {
		return "board/register";
	}
	
	@PostMapping("/register")
	public String register (Board board, RedirectAttributes rttr) {
		service.register(board);
		System.out.println(board);
		rttr.addFlashAttribute("result","register");
		rttr.addFlashAttribute("bno",board.getBno());
		return "redirect:list";
	}
	
	@PostMapping("/remove")
	public String remove(Long bno, RedirectAttributes rttr) {
		service.remove(bno);
		rttr.addFlashAttribute("result","remove")
			.addFlashAttribute("bno",bno);
		return "redirect:list";
	}
	/* ?????? */
	@GetMapping("/insertReply/{bno}")
	public String insertReplyWindowGET(@PathVariable("bno") Long bno, String memberName, Model model) {
		Board board = service.getBoardNumber(bno);
		model.addAttribute(board);
		model.addAttribute("boardNumber", bno);
		model.addAttribute("memberName", memberName);
		return "board/reply";
	}
}