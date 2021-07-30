package com.fei.rank.server.support;

import java.io.Serializable;

public class CallResult<T> implements Serializable
{
    private static final long serialVersionUID = -807909857321752537L;

    private String code;

    private String message;

    private T t;

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }

    public String getMessage()
    {
        return message;
    }

    public void setMessage(String message)
    {
        this.message = message;
    }

    public T getT()
    {
        return t;
    }

    public void setT(T t)
    {
        this.t = t;
    }
}
