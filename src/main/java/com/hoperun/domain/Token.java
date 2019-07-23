package com.hoperun.domain;

import java.io.Serializable;

public class Token implements Serializable {
    /**
     * token.token
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    private String token;

    /**
     * token.code
     * @ibatorgenerated 2017-09-24 22:25:33
     */
    private String code;


    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token= token;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}