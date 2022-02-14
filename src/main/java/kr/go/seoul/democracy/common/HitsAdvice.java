package kr.go.seoul.democracy.common;

import kr.go.seoul.democracy.adminNotice.model.vo.AdminNotice;
import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.common.model.service.HitsService;
import kr.go.seoul.democracy.common.model.service.HitsServiceImpl;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;
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

    /// CONSTRUCTORsdgk
    @Autowired
    public HitsAdvice(@Qualifier("hitsServiceImpl") HitsServiceImpl hService) {
        this.hService = hService;   // Service가 아닌 ServiceImpl을 호출하여 AOP 차단
        System.out.println(String.format("INFO - AOP: 조회수 처리를 위한 %s 객체 생성", this.getClass().getName()));
    }

    /// POINTCUT & Weaver
    // Suggest
    @Pointcut("execution(kr..Sug kr..service.*.*(..))")
    public void suggestPointCut() {}

    //@After("suggestPointCut()")
    public void hitSuggest(JoinPoint jp) {
        if (!(jp.getArgs()[0] instanceof Sug)) return;

        Sug value = (Sug) jp.getArgs()[0];
        if (value == null) return;

        hService.addCountHitsTable("SUGGEST_HITS", value.getSugNum());                                                  // TODO: REVISE
    }

    // Discuss
    @Pointcut("execution(kr..Discuss kr..service.*.*(..))")
    public void discussPointCut() {}

    //@After("discussPointCut()")
    public void hitDiscuss(JoinPoint jp) {
        if (!(jp.getArgs()[0] instanceof Discuss)) return;

        Discuss value = (Discuss) jp.getArgs()[0];
        if (value == null) return;

        hService.addCountHitsTable("DISCUSSION_HITS", value.getDiscussNo());
    }

    // Proposal
    @Pointcut("execution(kr..Proposal kr..service.*.*(..))")      // TODO: model
    public void proposalPointCut() {}

    //@After("proposalPointCut()")
    public void hitProposal(JoinPoint jp) {
        if (!(jp.getArgs()[0] instanceof Proposal)) return;

        Proposal value = (Proposal) jp.getArgs()[0];
        if (value == null) return;

        hService.addCountHitsTable("PROPOSAL_HITS", value.getProposalNo());
    }

    // Notice
    @Pointcut("execution(kr..BoardNotice kr..service.*.*(..))")
    public void noticePointCut() {}

    //@After("noticePointCut()")
    public void hitNotice(JoinPoint jp) {
        if (!(jp.getArgs()[0] instanceof BoardNotice)) return;

        BoardNotice value = (BoardNotice) jp.getArgs()[0];
        if (value == null) return;

        hService.addCountHitsTable("NOTICE_HITS", value.getNoticeNewsNo());
    }

    // NEWS
}
