package com.github.as.data.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Setter;
import lombok.ToString;
import lombok.Getter;

@Entity
@Table(name = "STBK_API_INFO")
@Getter
@Setter
@ToString
public class ApiInfo {

    @Id
    @GeneratedValue
    @Column(name="SQ_STBK_API_INFO_ID")
    private Integer id;
    
    private String serviceCode;
    
    private String ip;
    
    private String port;
    
    private String contextPath;
    
    private Date regDate;
    
    private String useYn;
}
