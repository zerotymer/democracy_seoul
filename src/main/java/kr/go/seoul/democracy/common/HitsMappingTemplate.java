package kr.go.seoul.democracy.common;

import java.util.Map;

public class HitsMappingTemplate {
    /// FIELDs
    private Map<String, String> tableMap;

    /// CONSTRUCTORs
    public HitsMappingTemplate(Map<String, String> tableMap) {
        this.tableMap = tableMap;
        System.err.println("테스트");
        System.err.println(tableMap);
    }

    /// METHODs
    public String getTableName(String className) {
        return this.tableMap.get(className);
    }
    public String getTableName(Object obj) {
        return this.tableMap.get(obj.getClass().getName());
    }

}
