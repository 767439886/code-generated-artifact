package com.jfeat.am.module.set.services.logMessage;

import com.jfeat.am.module.set.mapper.logMessage.HistoryPlayAndNowPlay;
import com.jfeat.am.module.set.model.Pushtimeadvertis;
import com.jfeat.am.module.set.tool.TimeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class HistoryPlayAndNowPlayService {

    @Autowired( required = false )
    HistoryPlayAndNowPlay historyPlayAndNowPlay ;

    //  使用于查询现在的数据
    public List<Pushtimeadvertis> searchNowPlayAdvertis ( ) {
        //  获取现在的时间
        String nowTime = TimeUtils.getNowTime() ;
        List<Pushtimeadvertis> pushtimeadvertis = historyPlayAndNowPlay.searchNowPlayAdvertis( nowTime ) ;
        return pushtimeadvertis ;
    }

    //  使用于查询历史的数据
    public List<Pushtimeadvertis> searchHistoryPlayAdvertis () {
        //  获取现在的时间
        String nowTime = TimeUtils.getNowTime() ;
        List<Pushtimeadvertis> pushtimeadvertis = historyPlayAndNowPlay.searchHistoryPlayAdvertis( nowTime ) ;
        return pushtimeadvertis ;
    }
}
