package kr.go.seoul.democracy.common;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import kr.go.seoul.democracy.board.model.vo.BoardNotice;
import kr.go.seoul.democracy.board.model.vo.Event;
import kr.go.seoul.democracy.board.model.vo.Referenceroom;
import kr.go.seoul.democracy.board.model.vo.SeoulNews;
import kr.go.seoul.democracy.common.model.service.HitsService;
import kr.go.seoul.democracy.common.model.service.HitsServiceImpl;
import kr.go.seoul.democracy.discuss.model.vo.Discuss;
import kr.go.seoul.democracy.proposal.model.vo.Proposal;
import kr.go.seoul.democracy.suggest.vo.Sug;

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
    @Pointcut("execution(kr..Sug kr..service.*.*(int))")
    public void suggestPointCut() {}

    @AfterReturning(pointcut = "suggestPointCut()", returning = "returnObj" )
    public void hitSuggest(Object returnObj) {
        if (!(returnObj instanceof Sug)) return;

        Sug value = (Sug) returnObj;
        if (value == null) return;

        hService.addCountHitsTable("SUGGEST_HITS", value.getSuggestNo());
    }

    // Discuss
    @Pointcut("execution(kr..Discuss kr..service.*.*(int))")
    public void discussPointCut() {}

    @AfterReturning(pointcut = "discussPointCut()", returning = "returnObj")
    public void hitDiscuss(Object returnObj) {
        if (!(returnObj instanceof Discuss)) return;
        
        Discuss value = (Discuss) returnObj;
        if (value == null) return;
        
        hService.addCountHitsTable("DISCUSSION_HITS", value.getDiscussNo());
    }

    // Proposal
    @Pointcut("execution(kr..Proposal kr..service.*.*(int))")      // TODO: model
    public void proposalPointCut() {}

    @AfterReturning(pointcut = "proposalPointCut()", returning = "returnObj")
    public void hitProposal(Object returnObj) {
        if (!(returnObj instanceof Proposal)) return;

        Proposal value = (Proposal) returnObj;
        if (value == null) return;

        hService.addCountHitsTable("PROPOSAL_HITS", value.getProposalNo());
    }

    // Notice
    @Pointcut("execution(kr..BoardNotice kr..service.*.*(int))")
    public void noticePointCut() {}

    @AfterReturning(pointcut = "noticePointCut()", returning = "returnObj")
    public void hitNotice(Object returnObj) {
        if (!(returnObj instanceof BoardNotice)) return;

        BoardNotice value = (BoardNotice) returnObj;
        if (value == null) return;

        hService.addCountHitsTable("NOTICE_HITS", value.getNoticeNewsNo());
    }

    // NEWS
    @Pointcut("execution(kr..SeoulNews kr..service.*.*(int))")
    public void newsPointCut() {}
    
    @AfterReturning(pointcut = "newsPointCut()", returning = "returnObj")
    public void hitNews(Object returnObj) {
    	if (!(returnObj instanceof SeoulNews)) return;

    	SeoulNews value = (SeoulNews) returnObj;
        if (value == null) return;

        hService.addCountHitsTable("NEWS_HITS", value.getSeoulNewsNo());
    }
    
    // Event
    @Pointcut("execution(kr..Event kr..service.*.*(int))")
    public void eventPointCut() {}
    
    @AfterReturning(pointcut = "eventPointCut()", returning = "returnObj")
    public void hitEvent(Object returnObj) {
    	if (!(returnObj instanceof Event)) return;

    	Event value = (Event) returnObj;
        if (value == null) return;

        hService.addCountHitsTable("EVENT_HITS", value.getEventNo());
    }
    
    // Referenceroom
    @Pointcut("execution(kr..Referenceroom kr..service.*.*(int))")
    public void referencePointCut() {}
    
    @AfterReturning(pointcut = "referencePointCut()", returning = "returnObj")
    public void referenceEvent(Object returnObj) {
    	if (!(returnObj instanceof Referenceroom)) return;

    	Referenceroom value = (Referenceroom) returnObj;
        if (value == null) return;

        hService.addCountHitsTable("REFERENCEROOM_HITS", value.getReferNo());
    }
}
