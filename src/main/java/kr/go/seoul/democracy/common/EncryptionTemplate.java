package kr.go.seoul.democracy.common;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptionTemplate {
    /// FIELDs
    final String METHOD = "SHA-256";
    final String KEY;

    /// CONSTURCTORs
    public EncryptionTemplate(String method, String key) {
        this.KEY = key;
    }

    /// METHODs

    /**
     * 문자열을 암호화하는 메소드
     * @param data 암호화할 문자열
     * @param salt 암호화에 사용할 salt
     * @return 암호화된 문자열
     * @throws NoSuchAlgorithmException
     * @author 신현진
     */
    public String encryptString(String data, String salt) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance(METHOD);
        String str = KEY + data + salt;
        digest.update(str.getBytes());

        BigInteger hash = new BigInteger(1, digest.digest());
        return hash.toString(16);        // TODO: CHECK
    }
}
