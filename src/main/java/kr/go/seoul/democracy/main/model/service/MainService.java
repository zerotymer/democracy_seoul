package kr.go.seoul.democracy.main.model.service;

import kr.go.seoul.democracy.main.model.vo.KeywordType;

import java.util.ArrayList;
import java.util.HashMap;

public interface MainService {
    ArrayList<HashMap<String, Object>> selectLatestSuggest(int count) ;
    ArrayList<HashMap<String, Object>> selectLatestDiscuss(int count) ;
    ArrayList<HashMap<String, Object>> selectLatestProposal(int count) ;

    ArrayList<HashMap<String, Object>> selectSearchKeyword(String keyword);
    ArrayList<HashMap<String, Object>> selectSearchKeyword(int currentPage, int pageSize, String keyword, KeywordType type);

    int selectCountKeyword(String keyword, KeywordType type);

}
