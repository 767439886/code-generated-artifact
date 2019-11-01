package com.jfeat.am.module.set.services.advertisSchedule;

import com.jfeat.am.module.set.mapper.advertisSchedule.AdvertisPushTimeMapper;
import com.jfeat.am.module.set.mapper.showTemplate.AdvertisTemplateMapper;
import com.jfeat.am.module.set.model.AdvertisBrand;
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

    public List<Pushtimeadvertis> searchPushTimeAdvertis ( String search ) {
        Map<String, Object> keywords = new HashMap<>() ;
        //  判断条件是否为空，不为空则加入条件处
        if ( search != null ) {
            keywords.put( "keywords" ,  search ) ;
        }
        List<Pushtimeadvertis> pushtimeadvertis = advertisPushTimeMapper.searchPushtimeAdvertis(keywords);
        return pushtimeadvertis ;
    }
}
