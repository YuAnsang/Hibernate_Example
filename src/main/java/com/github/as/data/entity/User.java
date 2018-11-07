package com.github.as.data.entity;

import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "STBK_USER_INFO")
@Getter
@Setter
public class User {
    
    @Id
    @Column(name="USER_ID")
    private String id;
    
    private String userName;
    
    private String password;
    
    private String email;
    
    private String authCode;
    
    private Date regDate;
    
    private Date lastLoginDate;
    
    private String useYn;
    
    private String initYn;
}
