package com.jfeat.am.module.set.mapper.logMessage;



import com.jfeat.am.module.set.model.AdvertisPlayTime;

import java.util.List;

public interface HistoryPlayAndNowPlay {

    //  搜索的正在推送的广告（注意要排序）
    public List<AdvertisPlayTime> searchNowPlayAdvertis(String day ) ;
    //  搜索的历史推送的广告（注意要排序）
    public List<AdvertisPlayTime> searchHistoryPlayAdvertis( String day ) ;
}
