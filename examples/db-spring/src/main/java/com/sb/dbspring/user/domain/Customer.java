package com.sb.dbspring.user.domain;

import javax.persistence.Entity;

@Entity
public class Customer extends User {

    private Integer purchasedProductNo;

    public Integer getPurchasedProductNo() {
        return purchasedProductNo;
    }

    public void setPurchasedProductNo(Integer purchasedProductNo) {
        this.purchasedProductNo = purchasedProductNo;
    }
}
