package kr.go.seoul.democracy.admin.model.service;

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

}