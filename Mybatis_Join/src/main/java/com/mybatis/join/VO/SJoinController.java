package com.mybatis.join.VO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SJoinController {

	@Autowired
	private SMybatisDAO smybatisDAO;
	
	@RequestMapping("/sjoinList.do")
	public String selectList(SJoinVO vo, Model model) {
		System.out.println("컨트롤러의 /sjoinList.do 호출 성공");
		List<SJoinVO> sjoinList = smybatisDAO.selectListSjoin(vo);
		System.out.println("sjoinList 에 객체 저장 성공");
		
		SJoinVO sjoinVO = sjoinList.get(0);
		SJoinVO sjoinVO1 = sjoinList.get(1);
		SJoinVO sjoinVO2 = sjoinList.get(2);
		
		System.out.println(sjoinVO.toString());
		System.out.println(sjoinVO1.toString());
		System.out.println(sjoinVO2.toString());
		
		model.addAllAttributes(sjoinList);
		
		return "sjoinList.jsp";
	}
	
}
