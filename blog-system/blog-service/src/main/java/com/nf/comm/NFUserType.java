package com.nf.comm;

/**
 * Created by James on 20/12/17.
 */
public enum NFUserType
{
    Admin(0, ""),
    Writer(1, ""),
    Visitor(2, "");
    
    NFUserType(int code, String flag)
    {
        this.code = code;
        this.flag = flag;
    }
    
    public int getCode()
    {
        return this.code;
    }
    
    public String getFlag()
    {
        return flag;
    }
    
    private int code;
    private String flag;
}
