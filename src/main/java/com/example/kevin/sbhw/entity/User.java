package com.example.kevin.sbhw.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 用户表(User)实体类
 *
 * @author kevin
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = -40356785423868312L;
    
    @Id
    private Long id;
    /**
    */
    private String userName;
    /**
    */
    private String nickName;
    /**
    */
    private String password;
    /**
    * user status（0 available 1 disable）
    */
    private String status;
    /**
    */
    private String email;
    /**
    */
    private String phonenumber;
    /**
    */
    private String sex;
    /**
    */
    private String avatar;
    /**
    * （0 admin，1 normal user）
    */
    private String userType;
    /**
    */
    private Long createBy;
    /**
    */
    private Date createTime;
    /**
    */
    private Long updateBy;
    /**
    */
    private Date updateTime;
    /**
    * （0 not delete，1 delete）
    */
    private Integer delFlag;
}

