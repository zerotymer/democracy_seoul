package kr.go.seoul.democracy.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

@Service("mss")
public class MailSendService {
	@Autowired
	private JavaMailSenderImpl mailSender;
	private int size;
	
	public boolean sendEmail(String checkNum,String email) {
		
		try {
			MailUtils sendMail = new MailUtils(mailSender);
			sendMail.setSubject("이메일 인증 메일");
			sendMail.setText(new StringBuffer().append("<h1>[이메일 인증]</h1>")
					.append("인증번호 : "+checkNum).toString());
			sendMail.setFrom("namj6917@gmail.com", "admin");
			sendMail.setTo(email);
			
			sendMail.send();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
		
	}

}
