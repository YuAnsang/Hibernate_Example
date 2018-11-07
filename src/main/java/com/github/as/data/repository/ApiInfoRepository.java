package com.github.as.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import com.github.as.data.entity.ApiInfo;

public interface ApiInfoRepository extends JpaRepository<ApiInfo, Integer>, QueryDslPredicateExecutor<ApiInfo> {

}
