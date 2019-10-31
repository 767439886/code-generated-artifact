package com.jfeat.am.module.set.api.advertismaterial;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.services.advertisMaterial.AdvertisTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/advertismaterial")
public class AdvertisBrandController {

    @Autowired
    private AdvertisTemplateService advertisTemplateService;

    //  查看出所有的广告模板信息
    @GetMapping( "/brandManager")
    public Result searchAllAdvertis ()  {
        try {
            List<AdvertisBrand> advertisBrands = advertisTemplateService.searchAllBrand() ;
            return new Result( advertisBrands , "返回的数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "数据返回失败" , 500 ) ;
        }
    }

    //  增加广告的模板信息
    @PostMapping( "/brandManager" )
    public Result addAdvertis(@RequestBody AdvertisBrand addBrand ) {
        try {
            advertisTemplateService.addBrandAdvertis( addBrand ); ;
            return new Result( "增加数据成功" , 200 ) ;
        } catch ( Exception e  ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

    //  把数据返回给广告页面
    @GetMapping( "/brandManager/{id}")
    public Result updateAdvertis ( @PathVariable String id ) {
        try {
            Map<String, Object> advertisBrand = advertisTemplateService.showBrandAdvertis(id);
            return new Result(  advertisBrand , "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

    //  把修改后的数据输入数据库
    @PutMapping( "/brandManager/{id}" )
    public Result saveAdvertis (  @PathVariable String id , @RequestBody Map<String,String> brandAdvertis ) {
        try {
            advertisTemplateService.updateBrandAdvertis( brandAdvertis );
            return new Result(  "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

    //  删除数据
    @DeleteMapping( "/brandManager/{id}" )
    public Result deleteAdvertis ( @PathVariable String id ) {
        try {
            advertisTemplateService.deleteBrandAdvertis( id ) ;
            return new Result(  "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }
}
