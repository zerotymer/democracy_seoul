package kr.go.seoul.democracy.suggest2.model.dao;

import kr.go.seoul.democracy.suggest2.model.vo.Suggest;
import org.apache.ibatis.session.RowBounds;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
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
    public int insertPost(Suggest suggest) {
        return template.insert("suggest2.insertPost", suggest);
    }

    /**
     *
     * @param param
     * @return
     * @author 신현진
     */
    public int updatePost(Suggest suggest) {
        return template.update("suggest2.updatePost", suggest);
    }

    public Suggest selectPost(int suggestNo) {
        return template.selectOne("suggest2.selectPost", suggestNo);
    }

    public ArrayList<HashMap<String, Object>> selectDonePost(int currentPage, int pageSize) {
        RowBounds rb = new RowBounds((currentPage - 1) * pageSize, pageSize);
        return new ArrayList<HashMap<String, Object>>(template.selectList("suggest2.doneSuggestion", null, rb));
    }
}
