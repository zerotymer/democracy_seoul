package kr.go.seoul.democracy.common;

import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import kr.go.seoul.democracy.common.model.vo.Member;

/**
 * 암호화를 위한 Advice
 * @author 신현진
 */

public class EncryptAdvice {
	/// FIELDs
		private EncryptionTemplate template;

		/// CONSTRUCTORs
		public EncryptAdvice(EncryptionTemplate template) {
			this.template = template;
			System.err.println("생성확인");
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

		/**
		 * 사용자의 Password를 암호화
		 * @param jp
		 */
		public void encryptPasswordForHashMap(JoinPoint jp) throws NoSuchAlgorithmException {
			if (!(jp.getArgs()[0] instanceof HashMap)) return;
			HashMap<String, Object> map = (HashMap<String, Object>) jp.getArgs()[0];

			String userId = (String) map.get("userId");
			String userPwd = (String) map.get("userPwd");

			String data = this.template.encryptString(userPwd, userId);
			map.put("userPwd", data);
		}
		
		public void test() {
			System.out.println("--------------------------------------------------------------------아따 포인트 컷");
		}
}
