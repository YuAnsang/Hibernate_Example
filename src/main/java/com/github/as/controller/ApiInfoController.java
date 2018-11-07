package com.github.as.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.github.as.data.entity.ApiInfo;
import com.github.as.search.BaseSearch;
import com.github.as.service.ApiInfoService;
import com.github.as.service.ApiInfoServiceImpl;

@RestController
@RequestMapping("/api")
public class ApiInfoController {

    @Autowired
    private ApiInfoService apiInfoService;
    
    @GetMapping("/list")
    @ResponseBody
    public Page<ApiInfo> getApiList(BaseSearch search, Pageable pageable) {
        System.out.println(search);
        return apiInfoService.getApiInfoList(pageable);
    }
    
    
}
