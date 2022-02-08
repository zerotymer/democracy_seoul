package kr.go.seoul.democracy.common.model.service;

public interface HitsService {
    boolean insertHitsTable(String tableName, int boardNo);
    boolean addCountHitsTable(String tableName, int boardNo);
    int getCountHitsTable(String tableName, int boardNo);
}
