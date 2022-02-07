package kr.go.seoul.democracy.admin.model.service;

import java.util.HashMap;

import kr.go.seoul.democracy.admin.model.vo.Admin;

public interface AdminService {

	Admin selectLoginAdmin(Admin admin);

	int updatePassword(HashMap<String, Object> map);

	int updateWithdraw(String adminId, String adminPwd);

	int insertAdminMember(Admin a);

}
