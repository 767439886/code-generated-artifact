package com.jfeat.am.module.set.mapper.advertisSchedule;

import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.model.Pushtimeadvertis;
import java.util.List;
import java.util.Map;

public interface AdvertisPushTimeMapper {
    //  搜索的要推送的广告（注意要排序）
    public List<Pushtimeadvertis> searchPushtimeAdvertis(Map<String, Object> map ) ;
    //  增加要推送的广告
    public void addPushtimeAdvertis( AdvertisBrand advertisBrand ) ;
    //  删除要推送的广告
    public void deletePushtimeAdvertis ( String id ) ;
    //  修改要推送的广告
    public void updatePushtimeAdvertis ( String id ) ;
}
