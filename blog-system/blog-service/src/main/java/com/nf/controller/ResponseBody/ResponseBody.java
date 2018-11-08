package com.nf.controller.ResponseBody;

import com.nf.comm.NFResCode;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by James on 25/02/18.
 */


@Component
@Data
public class ResponseBody
{
    private int code;
    private String message;
    
    public ResponseBody() {
        this.code = NFResCode.RES_FAILED.getCode();
        this.message = NFResCode.RES_FAILED.getFlag();
    }
    
    public void setCode(NFResCode resCode)
    {
        
        code = resCode.getCode();
        message = resCode.getFlag();
    }
}
