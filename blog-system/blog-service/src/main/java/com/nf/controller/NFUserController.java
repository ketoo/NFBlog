package com.nf.controller;

import com.nf.comm.NFResCode;
import com.nf.controller.RequestBody.NFRequestLoginBody;
import com.nf.controller.ResponseBody.NFResLoginBody;
import com.nf.schedule.NFSchedule;
import com.nf.services.NFIUserModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by James on 10/03/18.
 */
@RestController
@RequestMapping("/user")
public class NFUserController
{
    @Autowired
    NFSchedule schedule;

    @Autowired
    NFIUserModule userModule;
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> login(@RequestBody NFRequestLoginBody params)
    {
        NFResLoginBody xResLoginBody = new NFResLoginBody();
        
        String strJwt = userModule.login(params.getUser(), params.getPassword());
        if (strJwt != null && !strJwt.isEmpty())
        {
            xResLoginBody.setJwt(strJwt);
            xResLoginBody.setUserID(params.getUser());
            xResLoginBody.setCode(NFResCode.RES_SUCCESS);
    
            return new ResponseEntity<>(xResLoginBody, HttpStatus.OK);
        }
    
        
        return new ResponseEntity<>(xResLoginBody, HttpStatus.OK);
    }
}
