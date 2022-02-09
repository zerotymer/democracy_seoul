package kr.go.seoul.democracy.common;

import kr.go.seoul.democracy.common.model.service.HitsService;
import kr.go.seoul.democracy.common.model.service.HitsServiceImpl;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.proposal.vo.Proposal;
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

    /// POINTCUT & Weaver
    @Pointcut("execution(kr.go.seoul.democracy.suggest.vo.Sug kr..service.*.*(..))")
    public void suggetPointCut() {}

    public void hitSuggest(JoinPoint jp) {
        if (!(jp.getArgs()[0] instanceof Sug)) return;

        Sug value = (Sug) jp.getArgs()[0];
        if (value == null) return;

        hService.addCountHitsTable("SUGGEST_HITS", 1);                                           // TODO: REVISE
    }

    @Pointcut("execution(kr.go.seoul.democracy.discuss.model.vo.Discuss kr..service.*.*(..))")
    public void discussPointCut() {}

    public void hitDiscuss(JoinPoint jp) {
        if (!(jp.getArgs()[0] instanceof Discuss)) return;

        Discuss value = (Discuss) jp.getArgs()[0];
        if (value == null) return;

        hService.addCountHitsTable("DISCUSSION_HITS", value.getDiscussNo());
    }

    @Pointcut("execution(kr.go.seoul.democracy.proposal.vo.Proposal kr..service.*.*(..))")      // TODO: model
    public void proposalPointCut() {}

    public void hitProposal(JoinPoint jp) {
        if (!(jp.getArgs()[0] instanceof Proposal)) return;

        Proposal value = (Proposal) jp.getArgs()[0];
        if (value == null) return;

        hService.addCountHitsTable("PROPOSAL_HITS", value.getProposalNo());
    }


}
