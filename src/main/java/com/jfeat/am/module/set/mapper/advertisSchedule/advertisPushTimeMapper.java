package com.jfeat.am.module.set.mapper.advertisSchedule;

import com.jfeat.am.module.set.model.AdvertisBrand;
import java.util.List;
import java.util.Map;

public interface advertisPushTimeMapper {
    //  搜索的要推送的广告（注意要排序）
    public List<AdvertisBrand> searchPushtimeAdvertis(Map<String, String> map ) ;
    //  增加要推送的广告
    public void addPushtimeAdvertis( AdvertisBrand advertisBrand ) ;
    //  删除要推送的广告
    public void deletePushtimeAdvertis ( String id ) ;
    //  修改要推送的广告
    public void updatePushtimeAdvertis ( String id ) ;
}
