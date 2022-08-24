package me.eun.model;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class ReplyDTO {
	
	   private Long rno;
	   private Long bno;
	   private String memberName;
	   private String content;
	   private LocalDateTime regDate;
}
