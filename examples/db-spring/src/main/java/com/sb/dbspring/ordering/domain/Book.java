package com.sb.dbspring.ordering.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("2")
public class Book extends Item {

    private int noOfPages;

    public int getNoOfPages() {
        return this.noOfPages;
    }

    public void setNoOfPages(final int noOfPages) {
        this.noOfPages = noOfPages;
    }


}
