package kr.go.seoul.democracy.adminNotice.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.adminNotice.model.dao.AdminNoticeDAO;

@Service
public class AdminNoticeImpl implements AdminNoticeService{
	
	@Autowired
	private AdminNoticeDAO nDAO;

}
