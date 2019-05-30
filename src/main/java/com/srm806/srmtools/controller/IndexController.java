package com.srm806.srmtools.controller;

import com.srm806.srmtools.domain.ToolsList;
import com.srm806.srmtools.repository.ToolsListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * 显示网页的控制器
 */
@Controller
public class IndexController {

	@Autowired
	private ToolsListRepository toolsListRepository;

	@GetMapping("/index")
	public String showIndex(Model model) {
		List<ToolsList> toolsList = toolsListRepository.findAll();
		model.addAttribute("toolsList", toolsList);
		return "index";
	}

	/**
	 * 返回各个计算模块的视图
	 * @param id 模块id
	 * @param model
	 * @return
	 */
	@GetMapping("/module/{id}")
	public String showModule(@PathVariable Integer id, Model model){
		ToolsList tool = toolsListRepository.getOne(id);
		List<ToolsList> toolsList = toolsListRepository.findAll();
		model.addAttribute("toolsList", toolsList);
		model.addAttribute("tool", tool);
		return tool.getToolAlias();
	}
}
