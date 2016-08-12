package com.wangdm.tutorial.shiro.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.wangdm.base.entity.BaseEntity;
import com.wangdm.base.constant.EntityType;

@Entity
@Table(name="logrecord")
public class LogRecord extends BaseEntity {

    private static final long serialVersionUID = 9059404825378168250L;
    
    public static final EntityType entityType = EntityType.LOGRECORD;

}
