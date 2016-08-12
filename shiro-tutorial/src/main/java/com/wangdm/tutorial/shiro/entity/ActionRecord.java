package com.wangdm.tutorial.shiro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.wangdm.base.entity.BaseEntity;
import com.wangdm.base.constant.EntityType;

@Entity
@Table(name="actionrecord")
public class ActionRecord extends BaseEntity {

    private static final long serialVersionUID = -7487100189782404174L;
    
    public static final EntityType entityType = EntityType.ACTIONRECORD;

}
