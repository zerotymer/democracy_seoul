package kr.go.seoul.democracy.common;

import kr.go.seoul.democracy.common.model.service.HitsService;
import kr.go.seoul.democracy.common.model.service.HitsServiceImpl;
import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 조회수 처리를 위한 Advice
 */
public class HitsAdvice {
    /// FIELDs
    private HitsService hService;

    /// CONSTRUCTORs
    @Autowired
    public HitsAdvice(@Qualifier("hitsServiceImpl") HitsServiceImpl hService) {
        this.hService = hService;   // Service가 아닌 ServiceImpl을 호출하여 AOP 차단
    }

    public void addCountHitsSuggest(JoinPoint jp) {

    }
    public void addCountHitsDiscussion(JoinPoint jp) {

    }

    public void addCountHitsProposal(JoinPoint jp) {

    }


}
