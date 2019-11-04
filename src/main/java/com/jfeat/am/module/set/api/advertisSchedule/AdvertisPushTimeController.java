package com.jfeat.am.module.set.api.advertisSchedule;

import com.jfeat.am.module.set.Exception.TimeException;
import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.Pushtimeadvertis;
import com.jfeat.am.module.set.services.advertisSchedule.AdvertisPushTimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

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
            List<Pushtimeadvertis> pushtimeadvertis = advertisPushTimeService.searchPushTimeAdvertis(search);
            return new Result( pushtimeadvertis ,  "返回的数据成功" , 200 ) ;
        }catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "返回数据失败" , 500 ) ;
        }
    }

    //  使用增加功能
    @PostMapping
    public Result addAdvertis(@RequestBody Pushtimeadvertis pushtimeadvertis ) {
        try {
            //  暂时使用的是用户管理员的id
            pushtimeadvertis.setUid("1");
            advertisPushTimeService.addPushTimeAdvertis(pushtimeadvertis);
            return new Result("增加数据成功", 200);
        } catch ( TimeException e) {
            e.printStackTrace() ;
            return new Result( "时间输入错误" , 500 ) ;
        } catch ( Exception e  ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

    //  使用删除功能
    @DeleteMapping( "/{id}")
    public Result deleteAdvertis( @PathVariable String id ) {
        try {
            advertisPushTimeService.deletePushTimeAdvertis( id ) ;
            return new Result( "删除数据成功" , 200 ) ;
        } catch ( Exception e  ) {
            e.printStackTrace();
            return new Result( "删除数据失败" , 500 ) ;
        }
    }

    //  把数据返回给广告页面
    @GetMapping( "/{id}")
    public Result updateAdvertis ( @PathVariable String id ) {
        try {
            List<Pushtimeadvertis> pushtimeadvertis = advertisPushTimeService.showPushTimeAdvertis(id) ;
            return new Result(   pushtimeadvertis.get(0) , "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

    //  把修改后的数据输入数据库
    @PutMapping( "/{id}" )
    public Result saveAdvertis (@PathVariable String id , @RequestBody Map<String,Object> pushTimeAdvertis ) {
        try {
            advertisPushTimeService.updatePushTimeAdvertis( pushTimeAdvertis ) ;
            return new Result(  "增加数据成功" , 200 ) ;
        } catch ( TimeException e) {
            e.printStackTrace() ;
            return new Result( "时间修改错误" , 500 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }
}
