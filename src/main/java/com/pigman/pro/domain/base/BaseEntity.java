package com.pigman.pro.domain.base;

import java.io.Serializable;

/**
 * Created by liqiang on 2017/1/8.
 */
public class BaseEntity implements Serializable {
    private Long id;

    private Integer deletedFlag;

    public Integer getDeletedFlag() {
        return deletedFlag;
    }

    public void setDeletedFlag(Integer deletedFlag) {
        this.deletedFlag = deletedFlag;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
