package kr.go.seoul.democracy.main.model.service;

import kr.go.seoul.democracy.main.model.dao.MainDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.HashMap;

@Controller("mainService")
public class MainServiceImpl implements MainService {
    /// FIELDs
    private MainDAO mDAO;

    /// CONSTRUCTROs
    @Autowired
    public MainServiceImpl(@Qualifier("mainDAO") MainDAO mDAO) {
        this.mDAO = mDAO;
    }

    @Override
    public ArrayList<HashMap<String, Object>> selectLatestSuggest(int count) {
        return mDAO.selectLatestSuggest(count);
    }

    @Override
    public ArrayList<HashMap<String, Object>> selectLatestDiscuss(int count) {
        return mDAO.selectLatestDiscuss(count);
    }

    @Override
    public ArrayList<HashMap<String, Object>> selectLatestProposal(int count) {
        return mDAO.selectLatestProposal(count);
    }
}