package kr.go.seoul.democracy.adminNotice.model.service;

import java.util.ArrayList;

import kr.go.seoul.democracy.adminNotice.model.vo.AdminNotice;

public interface AdminNoticeService {

	ArrayList<AdminNotice> selectAllNoticeList(int currentPage, int recordCountPerPage);

	int noticeTotalCount();

	int insertNoticeWrite(AdminNotice adminNotice);
	
	AdminNotice selectOneNotice(int noticeNo);

	int noticeUpdate(AdminNotice an);

	
}
