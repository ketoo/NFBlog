package com.nf.controller;

import com.nf.controller.ResponseBody.ResponseBody;
import com.nf.module.NFILogModule;
import com.nf.schedule.NFSchedule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by James on 5/01/18.
 */
@RestController
@RequestMapping("/admin")
public class NFAdminController
{
    @Autowired
    NFSchedule schedule;
    
    @Autowired
    NFILogModule logModule;
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
  
    @RequestMapping(value = "/dobz", method = RequestMethod.POST)
    public ResponseEntity<?> doAnalysis(@RequestBody String date)
    {
        logger.info(date);
        
        //年月日
        //2018-01-03
        //start do analysis with date
        //String dateStr="2012-08-02";
        String dateStr = date;
        if (dateStr == logModule.getNowCalendar())
        {
            return new ResponseEntity<>(date, HttpStatus.BAD_REQUEST);
        }
        
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat dateFormat=new SimpleDateFormat(pattern);
        try
        {
            Date xDate = dateFormat.parse(dateStr);
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(xDate);
            schedule.DoBATask(calendar);
    
            return new ResponseEntity<>(date, HttpStatus.OK);
        }
        catch (ParseException e)
        {
            e.printStackTrace();
        }
        
        return new ResponseEntity<>(date, HttpStatus.BAD_REQUEST);
    }
    
    @RequestMapping(value = "/result/{date}", method = RequestMethod.GET)
    public ResponseEntity<?> queryResult(@PathVariable("date") String date)
    {
        ResponseBody xResponseBody = new ResponseBody();
        
        if (date == logModule.getLogDate())
        {
           
            return new ResponseEntity<>(xResponseBody, HttpStatus.OK);
        }
        
        
        return new ResponseEntity<>(xResponseBody, HttpStatus.BAD_REQUEST);
    }
}
