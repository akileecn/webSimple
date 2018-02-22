package cn.aki.controller;

import cn.aki.service.TranslateService;
import cn.aki.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/translate")
public class TranslateController {
    @Autowired
    private TranslateService translateService;

    @GetMapping("/dicts")
    public Response<Map<String, Map<String, String>>> getDicts(String[] types) {
        return Response.success(translateService.findDicts(types));
    }

    @RequestMapping("/dict")
    public Response<Map<String, String>> getDict(String type) {
        return Response.success(translateService.findDict(type));
    }
}
