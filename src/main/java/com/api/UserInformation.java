package com.api;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserInformation {

    @RequestMapping(value = "/getUser/{userId}",method = RequestMethod.GET)
    public String getUserName(@PathVariable String userId){
        String result = "";
        if("001".equals(userId)) {
            result = "hello A";
        }else if ("002".equals(userId)){
            result = "hello B";
        }else {
            result = "hello spring boot";
        }
        return result;
    }


}
