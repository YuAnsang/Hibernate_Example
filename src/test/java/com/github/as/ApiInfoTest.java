package com.github.as;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import com.github.as.config.HibernateConfiguration;
import com.github.as.config.RootContextConfiguration;
import com.github.as.config.ServletConfiguration;
import com.github.as.config.WebApplicationConfiguration;
import com.github.as.data.entity.ApiInfo;
import com.github.as.service.ApiInfoService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = {ServletConfiguration.class, RootContextConfiguration.class, WebApplicationConfiguration.class, HibernateConfiguration.class})
@Transactional
public class ApiInfoTest {

    @Autowired
    private ApiInfoService apiInfoService;
    
    @Test
    public void test() {
        // given
        PageRequest request = new PageRequest(10, 2, new Sort(Direction.DESC, "id"));
                
        // when
        Page<ApiInfo> apiList = apiInfoService.getApiInfoList(request);    
        
        // then
        for (ApiInfo apiInfo : apiList) {
            System.out.println(apiInfo.toString());
        }
        
    }
    
}
