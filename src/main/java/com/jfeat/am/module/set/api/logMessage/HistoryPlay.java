package com.jfeat.am.module.set.api.logMessage;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.Pushtimeadvertis;
import com.jfeat.am.module.set.services.advertisSchedule.AdvertisPushTimeService;
import com.jfeat.am.module.set.services.logMessage.HistoryPlayAndNowPlayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/logMessage/now")
public class HistoryPlay {

    @Autowired
    HistoryPlayAndNowPlayService historyPlayAndNowPlayService ;
    @Autowired
    AdvertisPushTimeService advertisPushTimeService ;

    //  使用查询得功能
    @GetMapping
    public Result SearchNowAdvertisPlay () {
        try{
            //  按照播放的时间进行排序查询
            List<Pushtimeadvertis> pushtimeadvertis = historyPlayAndNowPlayService.searchHistoryPlayAdvertis() ;
            return new Result(  pushtimeadvertis , "返回数据成功" , 500 ) ;
        }catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "返回数据失败" , 500 ) ;
        }
    }

    //  使用删除功能
    @DeleteMapping( "/{id}")
    public Result DeleteNowAdvertisPlay( @PathVariable String id ) {
        try {
            //   根据id删除广告
            advertisPushTimeService.deletePushTimeAdvertis( id ) ;
            return new Result( "删除数据成功" , 200 ) ;
        } catch ( Exception e  ) {
            e.printStackTrace();
            return new Result( "删除数据失败" , 500 ) ;
        }
    }
}
