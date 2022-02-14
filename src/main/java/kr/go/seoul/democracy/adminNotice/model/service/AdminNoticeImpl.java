package kr.go.seoul.democracy.adminNotice.model.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.adminNotice.model.dao.AdminNoticeDAO;
import kr.go.seoul.democracy.adminNotice.model.vo.AdminNotice;

@Service
public class AdminNoticeImpl implements AdminNoticeService{
	
	@Autowired
	private AdminNoticeDAO nDAO;

	@Override
	public ArrayList<AdminNotice> selectAllNoticeList(int currentPage, int recordCountPerPage) {
		return nDAO.selectAllNoticeList(recordCountPerPage, currentPage);
	}
	
	public int noticeTotalCount() {
		return nDAO.noticeTotalCount();
	}

	@Override
	public int insertNoticeWrite(AdminNotice adminNotice) {
		return nDAO.insertNoticeWrite(adminNotice);
	}

	@Override
	public int noticeUpdate(AdminNotice an) {
		return nDAO.noticeUpdate(an);
	}

}
