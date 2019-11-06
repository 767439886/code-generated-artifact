package com.jfeat.am.module.set.api.showTeleplate;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.Showtemplate;
import com.jfeat.am.module.set.services.showTemplate.AdvertisTemplateService;
import com.jfeat.am.module.set.services.showTemplate.PrograMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping( "/showTeleplate/usuallayTelemplate")
@RestController
public class UsuallayTelemplateController {

    @Autowired
    private AdvertisTemplateService advertisTemplateService;

    //  模板的数据搜索成功
    @GetMapping()
    public Result searchTemplate (String search ) {
        try {
            List<Showtemplate> showtemplates = advertisTemplateService.searchTemplate(search , "0" );
            return new Result( showtemplates , "返回的数据成功" , 200 ) ;
        } catch ( Exception e ) {
            return new Result( "返回数据失败" , 500 ) ;
        }
    }
}
