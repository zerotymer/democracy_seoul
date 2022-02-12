package kr.go.seoul.democracy.main.model.dao;

import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;

@Repository("mainDAO")
public class MainDAO {
    /// FIELDs
    private SqlSessionTemplate template;

    /// COSNTRUCTROs
    public MainDAO(@Qualifier("sqlSessionTemplate") SqlSessionTemplate template) {
        this.template = template;
    }

    /// METHODs
    public ArrayList<HashMap<String, Object>> selectLatestSuggest(int count) {
        return new ArrayList<HashMap<String, Object>>(template.selectList("main.latestSuggestion", count));
    }
    public ArrayList<HashMap<String, Object>> selectLatestDiscuss(int count) {
        return new ArrayList<HashMap<String, Object>>(template.selectList("main.latestDiscussion", count));
    }
    public ArrayList<HashMap<String, Object>> selectLatestProposal(int count) {
        return new ArrayList<HashMap<String, Object>>(template.selectList("main.latestProposal", count));
    }
    public ArrayList<HashMap<String, Object>> selectSearchKeyword(int currentPage, int pageSize, String keyword) {
        return new ArrayList<HashMap<String, Object>>(template.selectList("main.searchAll", keyword, new RowBounds((currentPage - 1) * pageSize, pageSize)));
    }

}
