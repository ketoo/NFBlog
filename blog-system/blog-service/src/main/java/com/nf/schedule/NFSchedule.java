package com.nf.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by lushenghuang on 20/12/17.
 */

@Service
public class NFSchedule
{
    private final Logger logger = LoggerFactory.getLogger(getClass());
    public final static long ONE_MIN =  60 * 1000;
    public final static long ONE_SECOND =  1000;

    private static String lastTime = null;

    @Scheduled(fixedDelay = ONE_SECOND * 3600)
    public void scheduleTaskfor()
    {
        if (lastTime == null)
        {
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            lastTime = sdf.format(cal.getTime());
        }
        
        Calendar cal1 = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strTime = sdf.format(cal1.getTime());
        
        if (!strTime.equals(lastTime))
        {
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DAY_OF_YEAR, -1);

            //do sth
        }
    }
}
