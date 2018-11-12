package com.nf.controller;

import com.nf.controller.ResponseBody.ResponseBody;
import com.nf.schedule.NFSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by James on 5/01/18.
 */
@RestController
@RequestMapping("/admin")
public class NFAdminController
{
    @Autowired
    NFSchedule schedule;

    
    private final Logger logger = LoggerFactory.getLogger(getClass());
  
    @RequestMapping(value = "/dobz", method = RequestMethod.POST)
    public ResponseEntity<?> doAnalysis(@RequestBody String date)
    {
        logger.info(date);

        return new ResponseEntity<>(date, HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/result/{date}", method = RequestMethod.GET)
    public ResponseEntity<?> queryResult(@PathVariable("date") String date)
    {
        ResponseBody xResponseBody = new ResponseBody();


        return new ResponseEntity<>(xResponseBody, HttpStatus.BAD_REQUEST);
    }
}
