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
		System.out.println("��Ʈ�ѷ��� /sjoinList.do ȣ�� ����");
		List<SJoinVO> sjoinList = smybatisDAO.selectListSjoin(vo);
		System.out.println("sjoinList �� ��ü ���� ����");
		
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
