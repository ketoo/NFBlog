package com.nf.controller.RequestBody;

import com.nf.comm.NFResCode;
import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by James on 10/03/18.
 */

@Component
@Data
public class NFRequestLoginBody extends RequestBaseBody
{
    private String  user;
    private String password;
    
    @Override
    NFResCode checkData()
    {
        return NFResCode.RES_SUCCESS;
    }
}
