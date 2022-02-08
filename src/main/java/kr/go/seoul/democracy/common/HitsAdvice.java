package kr.go.seoul.democracy.common;

import kr.go.seoul.democracy.common.model.service.HitsService;
import kr.go.seoul.democracy.common.model.service.HitsServiceImpl;
import kr.go.seoul.democracy.suggest.vo.Sug;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * 조회수 처리를 위한 Advice
 */
@Aspect
@Component
public class HitsAdvice {
    /// FIELDs
    private HitsService hService;

    /// CONSTRUCTORs
    @Autowired
    public HitsAdvice(@Qualifier("hitsServiceImpl") HitsServiceImpl hService) {
        this.hService = hService;   // Service가 아닌 ServiceImpl을 호출하여 AOP 차단
        System.out.println(String.format("INFO - AOP: 조회수 처리를 위한 %s 객체 생성", this.getClass().getName()));
    }

    /// POINTCUTs
    @Pointcut("execution(kr.go.seoul.democracy.suggest.vo.Sug kr..service.*.*())")
    public void suggetPointCut() {}

    @After("suggetPointCut()")
    public void hitSuggest(JoinPoint jp) {
        Sug sug = (Sug) jp.getArgs()[0];
        if (sug == null) return;

//        addCountHits("SUGGE");
        return;
    }
    public void addCountHitsDiscussion(JoinPoint jp) {

    }
    public void addCountHitsProposal(JoinPoint jp) {

    }

    private void addCountHits(String tableName, int boardNo) {
        hService.addCountHitsTable(tableName, boardNo);
    }
}
