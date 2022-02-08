package kr.go.seoul.democracy.common.model.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

@Repository("hitsDAO")
public class HitsDAO {
    /// FIELDs
    private SqlSessionTemplate template;

    /// CONSTRUCTORs
    @Autowired
    public HitsDAO(@Qualifier("sqlSessionTemplate") SqlSessionTemplate template) {
        this.template = template;
    }

    /// METHODs

}
