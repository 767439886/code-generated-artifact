package com.jfeat.am.module.set.mapper.showTemplate;

import com.jfeat.am.module.set.model.Showtemplate;
import java.util.List;
import java.util.Map;

public interface AdvertisTemplateMapper {
    //  搜索出关键字
    public List<Showtemplate> searchAdvertisTemplate(Map<String,String> keywords ) ;
    //  根据关键字增加模板
    public void insertuserTemplate( Showtemplate showtemplate ) ;
    //  根据id删除模板
    public void deleteTemplateAdvertis( String id ) ;
}
