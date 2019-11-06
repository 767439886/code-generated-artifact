package com.jfeat.am.module.set.api.showTeleplate;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.Showtemplate;
import com.jfeat.am.module.set.services.showTemplate.AdvertisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/showTeleplate" )
public class teleplateController {

    @Autowired
    private AdvertisTemplateService advertisTemplateService;

    //  模板的数据搜索成功
    @GetMapping( "/endTelemplate" )
    public Result searchTemplate ( String search ) {
        try {
            List<Showtemplate> showtemplates = advertisTemplateService.searchTemplate(search , "1");
            return new Result( showtemplates , "返回的数据成功" , 200 ) ;
        } catch ( Exception e ) {
            return new Result( "返回数据失败" , 500 ) ;
        }
    }

    //  增加广告的模板信息
    @PostMapping( "/endTelemplate")
    public Result addTemplate (@RequestBody Showtemplate showtemplate ) {
        try {
            advertisTemplateService.addTemplate( showtemplate ) ;
            return new Result( "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace() ;
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

    //  删除广告模板信息
    @DeleteMapping( "/endTelemplate/{id}" )
    public Result deleteTemplate (@PathVariable String id ) {
        try {
            advertisTemplateService.deleteTemplate(id) ;
            return new Result( "删除数据成功" , 200 ) ;
        } catch ( Exception e) {
            return new Result( "删除数据失败" , 500 ) ;
        }
    }

    //  返回模板的属性
    @GetMapping ( "/endTelemplate/{id}" )
    public Result showTemplate (@PathVariable String id ) {
        try {
            Showtemplate showtemplate = advertisTemplateService.showTemplate(id) ;
            return new Result( showtemplate , "删除数据成功" , 200 ) ;
        } catch ( Exception e) {
            return new Result( "删除数据失败" , 500 ) ;
        }
    }


    //  把修改后的数据输入数据库
    @PutMapping( "/endTelemplate/{id}" )
    public Result saveAdvertis (  @PathVariable String id , @RequestBody Showtemplate showtemplate ) {
        try {
            advertisTemplateService.updateTemplate( showtemplate ) ;
            return new Result(  "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }
}
