package com.nano.designpattern.responsibilitychain;

import lombok.Data;

/**
 * 请求类
 * @author nano
 */
@Data
public class Request {
    private RequestType type;
    private String name;

    public Request(RequestType type, String name) {
        this.type = type;
        this.name = name;
    }
}
