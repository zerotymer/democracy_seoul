package kr.go.seoul.democracy.common;

import kr.go.seoul.common.EncryptionTemplate;
import org.aspectj.lang.JoinPoint;

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
    }

    /// METHODs
    public void encryptPassword(JoinPoint jp) {
    }
}
