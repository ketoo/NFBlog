package com.nf.services.imp;

import com.google.gson.Gson;
import com.hazelcast.util.StringUtil;
import com.nf.model.NFUserModel;
import com.nf.services.NFINosqlModule;
import com.nf.services.NFIUserModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * Created by James on 10/03/18.
 */

@Service
public class NFUserModule implements NFIUserModule
{
    
    @Autowired
    private NFINosqlModule nosqlModule;
    
    private String getUserKey()
    {
        return "user_list";
    }
    
    
    @Override
    public String login(String user, String password)
    {
        if (StringUtil.isNullOrEmpty(user)
                || StringUtil.isNullOrEmpty(password))
        {
            return null;
        }
        
        NFUserModel xModel = getUser(user);
        if (xModel != null
                && xModel.getPassword().equals(password))
        {
            String strJWT = UUID.randomUUID().toString().replace("-", "");
            xModel.setJwt(strJWT);
            xModel.setLoginCount(xModel.getLoginCount() + 1);
            
            saveUser(xModel);
            
            return strJWT;
        }
        
        return null;
    }
    
    @Override
    public boolean checkJWT(String user, String jwt)
    {
        if (StringUtil.isNullOrEmpty(user)
                || StringUtil.isNullOrEmpty(jwt))
        {
            return false;
        }
        
        NFUserModel xModel = getUser(user);
        if (xModel != null && xModel.getJwt() != null
                && xModel.getJwt().equals(jwt))
        {
            return true;
        }
        
        return false;
    }
    
    @Override
    public NFUserModel getUser(String user)
    {
        String userData = nosqlModule.hGet(getUserKey(), user);
        if (!StringUtil.isNullOrEmpty(userData))
        {
            NFUserModel userModel = new Gson().fromJson(userData, NFUserModel.class);
            return userModel;
        }
        
        return null;
    }
    
    @Override
    public boolean saveUser(NFUserModel userModel)
    {
        return nosqlModule.hSet(getUserKey(), userModel.getOpenID(), new Gson().toJson(userModel));
    }
}
