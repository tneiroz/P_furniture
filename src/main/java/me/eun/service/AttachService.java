package me.eun.service;

import java.util.List;

import me.eun.model.AttachImageVO;

public interface AttachService {
	/* 이미지 데이터 반환 */
	public List<AttachImageVO> getAttachList(int productCode);
}
