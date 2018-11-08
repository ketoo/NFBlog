package com.nf.comm;

/**
 * Created by James on 9/03/18.
 */
public enum NFResCode
{
    RES_SUCCESS(0, "success"),
    RES_FAILED(1, "fail");
    
    NFResCode(int code, String flag)
    {
        this.code = code;
        this.flag = flag;
    }
    
    public static NFResCode getEnum(int code)
    {
        NFResCode[] enums = NFResCode.values();
        int c = NFResCode.values().length;
        for (int i = 0; i < c; i++)
        {
            if (i == code)
            {
                return enums[i];
            }
        }
        return null;
    }
    
    public static NFResCode getEnum(String desc)
    {
        NFResCode[] enums = NFResCode.values();
        int c = NFResCode.values().length;
        for (int i = 0; i < c; i++)
        {
            if (enums[i].flag.equals(desc.toUpperCase()))
            {
                return enums[i];
            }
        }
        return null;
    }
    
    public int getCode()
    {
        return this.code;
    }
    
    public String getFlag()
    {
        return this.flag;
    }
    
    public void setCode(int code)
    {
        this.code = code;
    }
    
    private int code;
    private String flag;
}
