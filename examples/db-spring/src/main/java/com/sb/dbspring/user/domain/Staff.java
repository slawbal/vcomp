package com.sb.dbspring.user.domain;

import javax.persistence.Entity;

@Entity
public class Staff extends User {

    private String privileges;

    public String getPrivileges() {
        return privileges;
    }

    public void setPrivileges(String privileges) {
        this.privileges = privileges;
    }
}
