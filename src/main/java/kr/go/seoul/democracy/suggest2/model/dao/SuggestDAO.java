package kr.go.seoul.democracy.suggest2.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Repository("suggestDAO")
public class SuggestDAO {
    /// FIELDs
    private SqlSessionTemplate template;

    /// CONSTRUCTORs
    @Autowired
    public SuggestDAO(@Qualifier("sqlSessionTemplate") SqlSessionTemplate template) {
        this.template = template;
    }

    /// METHODs

    /**
     * 제안 내용 추가
     * @param param
     * @return 
     * @author 신현진
     */
    public int insertPost(HashMap<String, Object> param) {
        return template.insert("suggest.insertPost", param);
    }

    /**
     *
     * @param param
     * @return
     * @author 신현진
     */
    public int updatePost(HashMap<String, Object> param) {
        return template.update("suggest.updatePost", param);
    }

}
