package cn.aki.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.aki.service.TranslateService;

@Controller
@RequestMapping("/translate")
public class TranslateController {
	@Autowired
	private TranslateService translateService;

	@ResponseBody
	@RequestMapping("/dicts")
	public Map<String,Map<String,String>> getDicts(String[] types){
		return translateService.findDicts(types);
	}
	
	@ResponseBody
	@RequestMapping("/dict")
	public Map<String,String> getDict(String type){
		return translateService.findDict(type);
	}
}
