package com.nf.controller.ResponseBody;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * Created by James on 10/03/18.
 */

@Component
@Data
public class NFResLoginBody extends ResponseBody
{
    private String jwt;
    private String userID;
}