package com.pigman.pro.domain;

import com.pigman.pro.domain.base.BaseEntity;

/**
 * 公众号类型
 * 17/01/08
 * @version   1.0
 * @author    pig man
 */
public class PnType extends BaseEntity {

    /** 类型描述 */
    String comments;

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}


//~ Formatted by Jindent --- http://www.jindent.com
