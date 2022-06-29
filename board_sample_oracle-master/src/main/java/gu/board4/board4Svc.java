package gu.board4;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import gu.common.FileVO;
import gu.common.SearchVO;

@Service
public class board4Svc {

	@Autowired
	private SqlSessionTemplate sqlSession;	
	@Autowired
	private DataSourceTransactionManager txManager;
		
    public Integer selectBoardCount(SearchVO param) throws Exception {
		return sqlSession.selectOne("selectBoard4Count", param);
    }
    public List<?> selectBoardList(SearchVO param) throws Exception {
		return sqlSession.selectList("selectBoard4List", param);
    }
    
    public void insertBoard(boardVO param, List<FileVO> filelist, String[] fileno) throws Exception {
    	
		DefaultTransactionDefinition def = new DefaultTransactionDefinition();
		def.setPropagationBehavior(TransactionDefinition.PROPAGATION_REQUIRED);
		TransactionStatus status = txManager.getTransaction(def);
		
		try{
			
			// 글쓰기 or 수정 을 확인하는 조건문
			/* 수정은 BoardRead.jsp 에서
			 * <a href="board4Form?brdno=<c:out value="${boardInfo.brdno}"/>">수정</a> 버튼으로 넘어오면
			 * value 에 추가된 boardInfo.brdno 값을 가져옴, 게시글 객체의 번호
			 * 
			 * 글쓰기는 boardList.jsp 에서 boardForm.jsp 로 이동하여
			 * post 방식으로 넘어올 때 brdno  없음
			 * 테이블에 추가될 때 brdno 가 생김 (BRDNO_SEQ)
			 */
			 
	    	if (param.getBrdno()==null || "".equals(param.getBrdno()))
	    		 sqlSession.insert("insertBoard4", param);
	    	else sqlSession.update("updateBoard4", param);
	
	    	if (fileno != null) {
	    	    HashMap p = new HashMap();
	    	    p.put("fileno", fileno) ;
	    	    sqlSession.delete("deleteBoard4File", p);
	    	}
	    	
	    	for (FileVO f : filelist) {
	    		//ParentPK 가 게시글의 번호임
	    		f.setParentPK(param.getBrdno());				
	   		 	sqlSession.insert("insertBoard4File", f);
	    	}
			txManager.commit(status);
		} catch (Exception ex) {
			// try 문에서 뭐 하나라도 안되면 롤백함 ,, ? all or nothing
			txManager.rollback(status);
			throw ex;
		}	    	
    }
 
    public boardVO selectBoardOne(String param) throws Exception {
		return sqlSession.selectOne("selectBoard4One", param);
    }
    
    public void updateBoard4Read(String param) throws Exception {
		sqlSession.insert("updateBoard4Read", param);
    }
    
    public void deleteBoardOne(String param) throws Exception {
		sqlSession.delete("deleteBoard4One", param);
    }
    
    public List<?> selectBoard4FileList(String param) throws Exception {
		return sqlSession.selectList("selectBoard4FileList", param);
    }
    
}
