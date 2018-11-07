package com.github.as.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.github.as.data.entity.ApiInfo;

public interface ApiInfoService {

    public Page<ApiInfo> getApiInfoList(Pageable pageable);
    
}
