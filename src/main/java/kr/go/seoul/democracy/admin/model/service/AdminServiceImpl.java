package kr.go.seoul.democracy.admin.model.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.go.seoul.democracy.admin.model.dao.AdminDAO;
import kr.go.seoul.democracy.admin.model.vo.Admin;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminDAO aDAO;

	@Override
	public Admin selectLoginAdmin(Admin admin) {
		
		Admin a = aDAO.selectLoginAdmin(admin);
		
		return a;
	}
	
	@Override
	public int adminUpdate(Admin a) {
		
		return aDAO.adminUpdate(a);
	}

	@Override
	public int updatePassword(HashMap<String, Object> map) {
		
		return aDAO.updatePassword(map);
	}

	@Override
	public int updateWithdraw(Admin admin) {
		
		return aDAO.updateWithdraw(admin);
	}

	@Override
	public int insertAdminMember(Admin a) {
		
		return aDAO.insertAdminMember(a);
	}

	@Override
	public int selectAdminIdCheck(String adminId) {
		
		return aDAO.selectAdminIdCheck(adminId);
	}

	@Override
	public ArrayList<Admin> selectAllMemberList() {
		
		return aDAO.selectAllMemberList();
	}

	@Override
	public int updateMemberEndYNChange(String userId, char endYN) {
		
		return aDAO.updateMemberEndYNChange(userId, endYN);
	}

	

}
