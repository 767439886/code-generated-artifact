package com.jfeat.am.module.set.api.advertisSchedule;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.services.advertisSchedule.AdvertisPushTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping( "/advertisSchedule/advertisPushTime" )
@RestController
public class AdvertisPushTimeController {

    @Autowired
    private AdvertisPushTimeService advertisPushTimeService ;

    @GetMapping
    public Result SearchAdvertisPushTime ( String search ) {
        try{
            //  发送搜索条件
            advertisPushTimeService.searchPushTimeAdvertis( search ) ;
            return new Result( "返回的数据成功" , 200 ) ;
        }catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "返回数据失败" , 500 ) ;
        }
    }

}
