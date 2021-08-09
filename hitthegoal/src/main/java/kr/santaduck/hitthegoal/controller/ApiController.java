package kr.santaduck.hitthegoal.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.santaduck.hitthegoal.dto.Goal;
import kr.santaduck.hitthegoal.service.GoalService;

@RestController
public class ApiController {

	@Autowired
	GoalService goalService;
	
	@GetMapping(path = "/goals")
	public Map<String, Object> getGoals(
			@RequestParam(name = "teamId", required = false, defaultValue = "0") int teamId,
			@RequestParam(name = "memberId", required = false, defaultValue = "0") int memberId) {
		
		// 목록 가져오기
		List<Goal> goals = goalService.getGoals(teamId, memberId);
		
		// 반환할 객체 만들기
		Map<String, Object> map = new HashMap<>();
		map.put("goals", goals);
		System.out.println("ㅎㅇ");
		
		return map;
	}
}
