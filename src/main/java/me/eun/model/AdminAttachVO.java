package me.eun.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString 
@NoArgsConstructor
@AllArgsConstructor

public class AdminAttachVO {
	/* 경로 */
	private String uploadPath;
	
	/* uuid */
	private String uuid;
	
	/* 파일 이름 */
	private String fileName;
	
	/* 상품 id */
	private int productName;
	
	
	public String getImageName() {
		StringBuilder builder = new StringBuilder();
		builder.append(uploadPath.replace("\\", "/"))
		.append("/")
		.append(uuid)
		.append("_")
		.append(fileName);
		return builder.toString();
	}
	
}
