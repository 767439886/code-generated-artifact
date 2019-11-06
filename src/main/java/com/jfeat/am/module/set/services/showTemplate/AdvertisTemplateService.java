package com.jfeat.am.module.set.services.showTemplate;
import com.jfeat.am.module.set.mapper.showTemplate.AdvertisTemplateMapper;
import com.jfeat.am.module.set.model.Showtemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class AdvertisTemplateService {

    @Autowired( required =  false )
    private AdvertisTemplateMapper advertisTemplateMapper ;

    //  主要用于搜索模板
    public List<Showtemplate> searchTemplate ( String keyword , String uid ) {
        Map<String, String> keywords = new HashMap<>();
        keywords.put( "uid" ,  uid ) ;
        if ( keyword != null ) {
            keywords.put("keyword", "%" + keyword + "%" );
        }
        List<Showtemplate> advertisTemplates = advertisTemplateMapper.searchAdvertisTemplate(keywords);
        return advertisTemplates ;
    }

    //  主要用于增加模板
    public void addTemplate( Showtemplate showtemplate ) {
        // 暂时判断该showtemplate中的uid为1(做完用户登录再获取uid)
        showtemplate.setUid(1) ;
        //  用于增加模板
        advertisTemplateMapper.insertuserTemplate( showtemplate ) ;
    }

    //  主要用于删除模板
    public void deleteTemplate( String id ) {
        //  使用于删除模板
        advertisTemplateMapper.deleteTemplateAdvertis(id);
    }

    //  修改模板
    public void updateTemplate ( Showtemplate showtemplate ) {
        //  先删除
        this.deleteTemplate( showtemplate.getId().toString() ) ;
        //  再增加
        this.addTemplate( showtemplate ) ;
    }

    //  返回模板的信息
    public Showtemplate showTemplate ( String id ) {
        Map<String,String> keywords = new HashMap<>() ;
        keywords.put( "id" , id ) ;
        List<Showtemplate> showtemplates = advertisTemplateMapper.searchAdvertisTemplate(keywords) ;
        return showtemplates.get(0) ;
    }
}
