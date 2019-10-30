package com.jfeat.am.module.set.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/advertis")
public class advertisController {

    @RequestMapping( "/searchAllAdvertis")
    public void searchAllAdvertis ()  {
        try {
            System.out.println( "收到" );
        } catch ( Exception e ) {

        }
    }

    @RequestMapping( "/test")
    public void test () {
        System.out.println( "已经输出了" ) ;
    }
}
