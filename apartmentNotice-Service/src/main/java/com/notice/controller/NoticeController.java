package com.notice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.notice.entity.NoticeModelEntity;
import com.notice.model.NoticeResponseBean;
import com.notice.service.NoticeService;
import com.notice.util.NoticeConstant;


@RestController
@RequestMapping(value="/noticeservice")
public class NoticeController {
	
	@Autowired
	private NoticeService service;
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);
	
	@RequestMapping(value=NoticeConstant.ENDPOINT_CREATE, method=RequestMethod.POST, produces= {"multipart/form-data"}, consumes= {"multipart/form-data"})
	public ResponseEntity<String> createNotice(@RequestParam("apartementId") String apartementId, @RequestParam("userId") String userId,
			@RequestParam("postByUserId") String postByUserId, @RequestParam("visibility") String visibility, @RequestParam("noticeText") String noticeText,
			@RequestPart("file") MultipartFile file) throws IOException{
		NoticeResponseBean noticeResponseBean=new NoticeResponseBean();
		List<NoticeModelEntity> list=new ArrayList<>();
		NoticeModelEntity modelEntity = new NoticeModelEntity();
		modelEntity.setApartementId(apartementId);
		modelEntity.setUserId(userId);
		modelEntity.setPostByUserId(postByUserId);
		modelEntity.setVisibility(visibility);
		modelEntity.setNoticeText(noticeText);
		modelEntity.setNoticeStartDate(null);
		modelEntity.setNoticeExpDate(null);
		modelEntity.setAttachement(file.getBytes());
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
		
//		
		return new ResponseEntity<String>(noticeResponseBean.toString(),HttpStatus.OK);
     	}
	
	

}
