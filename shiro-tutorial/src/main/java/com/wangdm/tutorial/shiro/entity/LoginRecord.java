package com.wangdm.tutorial.shiro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.wangdm.base.entity.BaseEntity;
import com.wangdm.base.constant.EntityType;

@Entity
@Table(name="loginrecord")
public class LoginRecord extends BaseEntity {

    private static final long serialVersionUID = -4998972298297668158L;
    
    public static final EntityType entityType = EntityType.LOGINRECORD;

}
