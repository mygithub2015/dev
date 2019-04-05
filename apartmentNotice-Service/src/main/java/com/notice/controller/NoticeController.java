package com.notice.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.notice.entity.NoticeModelEntity;
import com.notice.model.NoticeResponseBean;
import com.notice.service.NoticeService;
import com.notice.util.NoticeConstant;


@RestController
@RequestMapping(name="noticeservice")
public class NoticeController {
	
	@Autowired
	NoticeService service;
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@PostMapping(NoticeConstant.ENDPOINT_CREATE)
	public NoticeResponseBean createNotice(@RequestBody NoticeModelEntity modelEntity){
		NoticeResponseBean noticeResponseBean=new NoticeResponseBean();
		List<NoticeModelEntity> list=new ArrayList<>();
		modelEntity=service.createNotice(modelEntity);
		if(modelEntity!=null){
			list.add(modelEntity);
			noticeResponseBean.setStatus_Code(NoticeConstant.STATUS_CODE);
			noticeResponseBean.setMessage(NoticeConstant.MESSAGE);
			noticeResponseBean.setUserList(list);
			logger.info(NoticeConstant.SUCCESS);
		}else{
			logger.error(NoticeConstant.ERROR_MESG);
		}
		return noticeResponseBean;
     	}
	
	

}
