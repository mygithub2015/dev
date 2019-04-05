package com.notice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.notice.entity.NoticeModelEntity;
import com.notice.repository.NoticeRepository;

@Service
public class NoticeServiceImpl implements NoticeService{
	
	@Autowired
	NoticeRepository noticeRepository;

	@Override
	public NoticeModelEntity createNotice(NoticeModelEntity noticeModelEntity) {
		
		return noticeRepository.save(noticeModelEntity);
	}

}
