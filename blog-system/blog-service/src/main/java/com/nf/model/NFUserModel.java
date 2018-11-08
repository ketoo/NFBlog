package com.nf.model;

import com.nf.comm.NFUserType;
import lombok.Data;

/**
 * Created by James on 10/03/18.
 */
@Data
public class NFUserModel
{
    private String openID;
    
    private String userName;
    
    private String password;
    
    private String secretKey;
    
    private String email;
    
    private String jwt;
    
    private int loginCount;
    
    private NFUserType admin;
}
