package kr.go.seoul.democracy.suggest2.model.service;

import java.util.HashMap;

public interface SuggestService {
    boolean insertPost(HashMap<String, Object> params);
    boolean updatePost(HashMap<String, Object> params);
}
