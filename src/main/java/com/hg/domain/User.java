package com.hg.domain;

import java.io.Serializable;

public class User implements Serializable {
    /**
     * user.uid
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    private Integer uid;

    /**
     * user.uname
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    private String uname;

    /**
     * user.upassword
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    private String upassword;

    /**
     * user.code
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    private String code;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}