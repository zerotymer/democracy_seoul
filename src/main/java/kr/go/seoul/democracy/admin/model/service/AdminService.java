package kr.go.seoul.democracy.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import kr.go.seoul.democracy.admin.model.vo.Admin;

public interface AdminService {

	Admin selectLoginAdmin(Admin admin);
	
	int adminUpdate(Admin a);

	int updatePassword(HashMap<String, Object> map);

	int updateWithdraw(Admin admin); 

	int insertAdminMember(Admin a);

	int selectAdminIdCheck(String adminId);

	ArrayList<Admin> selectAllMemberList();

	int updateMemberEndYNChange(String userId, char endYN);

	ArrayList<Admin> selectAllPostList(int currentPage, int recordCountPerPage);

	HashMap<String, Object> getAdminPageNavi(int currentPage, int recordCountPerPage, int naviSize);
	
}
