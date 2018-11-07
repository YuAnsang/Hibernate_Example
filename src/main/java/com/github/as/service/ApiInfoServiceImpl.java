package com.github.as.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.github.as.data.entity.ApiInfo;
import com.github.as.data.repository.ApiInfoRepository;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

@Service
public class ApiInfoServiceImpl implements ApiInfoService {

    @Autowired
    private ApiInfoRepository apiInfoRepository;

    @Override
    public Page<ApiInfo> getApiInfoList(Pageable pageable) {
        return apiInfoRepository.findAll(generatePredicate(), pageable);
    }

    private Predicate generatePredicate() {
        //QApiInfo apiInfo = QApiInfo.apiInfo;
        BooleanBuilder builder = new BooleanBuilder();
        return builder;
    }
}
