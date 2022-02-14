package kr.go.seoul.democracy.common;

import kr.go.seoul.democracy.admin.model.vo.Admin;
import kr.go.seoul.democracy.common.model.vo.Member;
import org.aspectj.lang.JoinPoint;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;

/**
 * 암호화를 위한 Advice
 * @author 신현진
 */

public class EncryptAdvice {
	/// FIELDs
	private EncryptionTemplate template;
	private List<String> saltList;
	private List<String> dataList;

	/// CONSTRUCTORs
	public EncryptAdvice(EncryptionTemplate template,
						 List<String> saltList,
						 List<String> dataList) {
		this.template = template;
		this.saltList = saltList;
		this.dataList = dataList;
	}
	
	/**
	 * 사용자의 Password를 암호화
	 * @param jp: data(Member.userPwd), salt(Member.userId)
	 * @throws NoSuchAlgorithmException
	 */
	public void encryptPasswordForMember(JoinPoint jp) throws NoSuchAlgorithmException {
		if (!(jp.getArgs()[0] instanceof Member)) return;

		Member member = jp.getArgs()[0] != null ? (Member) jp.getArgs()[0] : null;
		if (member == null) return;

		String data = this.template.encryptString(member.getUserPwd(), member.getUserId());
		member.setUserPwd(data);
	}

	public void encryptPasswordForAdmin(JoinPoint jp) throws NoSuchAlgorithmException {
		if (!(jp.getArgs()[0] instanceof Admin)) return;

		Admin admin = jp.getArgs()[0] != null ? (Admin) jp.getArgs()[0] : null;
		if (admin == null) return;

		String data = this.template.encryptString(admin.getAdminPwd(), admin.getAdminId());
		admin.setAdminPwd(data);
	}

	/**
	 * 사용자의 Password를 암호화
	 * @param jp
	 */
	public void encryptPasswordForHashMap(JoinPoint jp) throws NoSuchAlgorithmException {
		if (!(jp.getArgs()[0] instanceof HashMap)) return;
		HashMap<String, Object> map = (HashMap<String, Object>) jp.getArgs()[0];

		StringBuilder salt = new StringBuilder();
		saltList.stream().map(map::get).forEach(salt::append);

		for (String key : dataList) {
			if (map.containsKey(key))
				map.put(key, this.template.encryptString( (String)map.get(key), salt.toString()));
		}
	}
}
