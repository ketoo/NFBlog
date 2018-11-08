package com.nf.services;

import com.nf.model.NFUserModel;

/**
 * Created by James on 10/03/18.
 */
public interface NFIUserModule
{
    String login(String user, String password);
    boolean checkJWT(String user, String jwt);
    
    
    NFUserModel getUser(String user);
    boolean saveUser(NFUserModel userModel);
}
