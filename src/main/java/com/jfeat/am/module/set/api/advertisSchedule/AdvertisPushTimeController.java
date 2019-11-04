package com.jfeat.am.module.set.api.advertisSchedule;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.services.advertisSchedule.AdvertisPushTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping( "/advertisSchedule/advertisPushTime" )
@RestController
public class AdvertisPushTimeController {

    @Autowired
    private AdvertisPushTimeService advertisPushTimeService ;

    //  使用查询得功能
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

    //  使用增加功能
    @PostMapping
    public Result addAdvertis(@RequestBody AdvertisBrand addBrand ) {
        try {

            return new Result( "增加数据成功" , 200 ) ;
        } catch ( Exception e  ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

}
