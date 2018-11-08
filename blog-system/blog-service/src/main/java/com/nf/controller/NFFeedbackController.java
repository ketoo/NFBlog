package com.nf.controller;

import com.nf.DAO.*;
import com.nf.DAO.StaticType.*;
import com.nf.comm.NFResCode;
import com.nf.controller.ResponseBody.ResponseBody;
import com.nf.module.NFILogModule;
import com.nf.schedule.NFSchedule;
import com.nf.services.imp.NFMysqlModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lushenghuang on 19/12/17.
 */

@RestController
@RequestMapping("/feedback")
public class NFFeedbackController
{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    
    @Autowired
    NFSchedule schedule;
    
    @Autowired
    NFILogModule logModule;

    @Autowired
    NFMysqlModule mysqlModule;

    ////////////////
    
    @Autowired
    NFActivityTypeDAO activityTypeDAO;
    
    @Autowired
    NFItemIDDAO itemIDDAO;
    
    @Autowired
    NFItemTypeDAO itemTypeDAO;

    @Autowired
    NFReasonDAO reasonDAO;
    
    @Autowired
    NFRoundIDDAO roundIDDAO;
    
    @Autowired
    NFRoundTypeDAO roundTypeDAO;
    
    @Autowired
    NFSubReasonDAO subReasonDAO;
    
    @Autowired
    NFTaskIDDAO taskIDDAO;
    
    @Autowired
    NFTaskTypeDAO taskTypeDAO;
    
    @Autowired
    NFZoneDAO zoneDAO;

    @Autowired
    NFSourceDAO sourceDAO;

    @Autowired
    NFActivityFlowDAO activityFlowDAO;
    
    @Autowired
    NFBlockFlowDAO blockFlowDAO;
    
    @Autowired
    NFDailyActivelyUsesDAO dailyActivelyUsesDAO;
    
    @Autowired
    NFDailyAVGOnlineTimeDAO dailyAVGOnlineTimeDAO;
    
    @Autowired
    NFDailyNewUsersDAO dailyNewUsersDAO;

    @Autowired
    NFDailyNewPlatUsersDAO dailyNewPlatUsersDAO;

    @Autowired
    NFDailyNewSourceUsersDAO dailyNewSourceUsersDAO;

    @Autowired
    NFDailyRetentionDAO dailyRetentionDAO;
    
    @Autowired
    NFItemFlowDAO itemFlowDAO;
    
    @Autowired
    NFLevelFlowDAO levelFlowDAO;
    
    @Autowired
    NFMoneyFlowDAO moneyFlowDAO;
    
    @Autowired
    NFOnlineFlowDAO onlineFlowDAO;
    
    @Autowired
    NFPayFlowDAO payFlowDAO;
    
    @Autowired
    NFPlayerBehaviourFlowDAO playerBehaviourFlowDAO;
    
    @Autowired
    NFRoleFlowDAO roleFlowDAO;
    
    @Autowired
    NFRoundFlowDAO roundFlowDAO;
    
    @Autowired
    NFTaskFlowDAO taskFlowDAO;
    
    @Autowired
    NFUserDataDAO userDataDAO;
    
    @Autowired
    NFUserDeviceDAO userDeviceDAO;

    @Autowired
    NFAPIFlowDAO apiFlowDAO;

    @Autowired
    NFUserPermissionDAO userPermissionDAO;

    static Map<String, Integer> mZoneIOSOnlineNumber = new HashMap<>();
    static Map<String, Integer> mZoneANDOnlineNumber = new HashMap<>();

    ////////////////
    @RequestMapping(value = "/clear", method = RequestMethod.POST)
    public ResponseEntity<?> clear(@RequestBody String params)
    {
        ResponseBody responseBody = new ResponseBody();


        responseBody.setCode(NFResCode.RES_SUCCESS);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }

    @RequestMapping(value = "/addlog", method = RequestMethod.POST)
    public ResponseEntity<?> addLog(@RequestBody String params)
    {
        ResponseBody responseBody = new ResponseBody();
        
    
        responseBody.setCode(NFResCode.RES_SUCCESS);
        return new ResponseEntity<>(responseBody, HttpStatus.OK);
    }
    
}
