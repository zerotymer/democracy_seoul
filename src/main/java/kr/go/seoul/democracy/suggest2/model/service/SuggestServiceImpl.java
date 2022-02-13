package kr.go.seoul.democracy.suggest2.model.service;

import kr.go.seoul.democracy.suggest2.model.dao.SuggestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service("suggestService")
public class SuggestServiceImpl implements SuggestService {
    /// FIELDs
    private SuggestDAO sDAO;

    /// CONSTRUCTOR
    @Autowired
    public SuggestServiceImpl(@Qualifier("suggestDAO") SuggestDAO suggestDAO) {
        this.sDAO = suggestDAO;
    }

    /// METHODs
    @Override
    public boolean insertPost(HashMap<String, Object> params) {
        return sDAO.insertPost(params) > 0;
    }

    @Override
    public boolean updatePost(HashMap<String, Object> params) {
        return sDAO.updatePost(params) > 0;
    }
}
