package kr.go.seoul.democracy.main.model.dao;

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

}
