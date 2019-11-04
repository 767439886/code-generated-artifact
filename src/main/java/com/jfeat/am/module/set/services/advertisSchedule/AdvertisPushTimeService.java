package com.jfeat.am.module.set.services.advertisSchedule;

import com.jfeat.am.module.set.Exception.TimeException;
import com.jfeat.am.module.set.mapper.advertisSchedule.AdvertisPushTimeMapper;
import com.jfeat.am.module.set.model.Pushtimeadvertis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class AdvertisPushTimeService {

    @Autowired( required =  false )
    private AdvertisPushTimeMapper advertisPushTimeMapper ;

    //  使用于查询数据
    public List<Pushtimeadvertis> searchPushTimeAdvertis ( String search ) {
        Map<String, Object> keywords = new HashMap<>() ;
        //  判断条件是否为空，不为空则加入条件处
        if ( search != null ) {
            keywords.put( "keywords" ,  search ) ;
        }
        List<Pushtimeadvertis> pushtimeadvertis = advertisPushTimeMapper.searchPushtimeAdvertis(keywords);
        return pushtimeadvertis ;
    }

    //  使用于增加数据
    public void addPushTimeAdvertis( Pushtimeadvertis pushtimeadvertis ) throws TimeException {
        //  判断结束时间 是否大于等于 开始时间
        if ( pushtimeadvertis.getStartTime().compareTo( pushtimeadvertis.getEndTime() ) <= 0 ){
            if ( pushtimeadvertis.getPlayTime().compareTo( pushtimeadvertis.getEndTime() ) <=0  ) {
                if ( pushtimeadvertis.getStartTime().compareTo( pushtimeadvertis.getPlayTime()) <= 0 ) {
                    advertisPushTimeMapper.addPushtimeAdvertis( pushtimeadvertis) ;
                    return ;
                }
            }
        }
        throw new TimeException( "时间错误输入" ) ;
    }

    //  使用于删除数据
    public void deletePushTimeAdvertis( String id ) {
        advertisPushTimeMapper.deletePushtimeAdvertis( id );
    }

    //  用于回显数据
    public List<Pushtimeadvertis> showPushTimeAdvertis( String id )  {
        Map<String , Object> hashMap = null ;
        if ( id != null && id != "" ) {
            hashMap = new HashMap<>() ;
            hashMap.put( "id" , id ) ;
        }
        List<Pushtimeadvertis> pushtimeadvertis = advertisPushTimeMapper.searchPushtimeAdvertis(hashMap) ;
        return pushtimeadvertis ;
    }

    //  用于修改数据
    public void updatePushTimeAdvertis ( Map<String,Object> pushTimeAdvertis ) throws TimeException {
        //  判断结束时间 是否大于等于 开始时间
        if ( ((String)pushTimeAdvertis.get("startTime")).compareTo( (String)pushTimeAdvertis.get("endTime") ) <= 0 ){
            if ( ((String)pushTimeAdvertis.get("playTime")).compareTo( (String)pushTimeAdvertis.get("endTime") ) <= 0  ) {
                if ( ((String)pushTimeAdvertis.get("startTime")).compareTo( (String)pushTimeAdvertis.get("playTime") ) <= 0 ) {
                    advertisPushTimeMapper.updatePushtimeAdvertis( pushTimeAdvertis);
                    return ;
                }
            }
        }
        throw new TimeException( "时间错误输入" ) ;
    }
}
