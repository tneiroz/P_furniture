package me.eun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import me.eun.mapper.AttachMapper;
import me.eun.model.AttachImageVO;

@Service
public class AttachServiceImpl implements AttachService {

	@Autowired
	private AttachMapper attachMapper;
	
	
	@Override
	public List<AttachImageVO> getAttachList(int productCode) {
		return attachMapper.getAttachList(productCode);
	}

}
