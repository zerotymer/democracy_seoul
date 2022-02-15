package kr.go.seoul.democracy.suggest2.model.service;

import kr.go.seoul.democracy.suggest2.model.dao.SuggestDAO;
import kr.go.seoul.democracy.suggest2.model.vo.Suggest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public boolean insertPost(Suggest suggest) {
        return sDAO.insertPost(suggest) > 0;
    }

    @Override
    public boolean updatePost(Suggest suggest) {
        return sDAO.updatePost(suggest) > 0;
    }

    @Override
    public Suggest selectPost(int suggestNo) {
        return sDAO.selectPost(suggestNo);
    }

    @Override
    public ArrayList<HashMap<String, Object>> selectDonePost(int currentPage, int pageSize) {
        return sDAO.selectDonePost(currentPage, pageSize); }
}
