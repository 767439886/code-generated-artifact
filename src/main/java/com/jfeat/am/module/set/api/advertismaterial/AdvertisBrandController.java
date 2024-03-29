package com.jfeat.am.module.set.api.advertismaterial;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.services.advertisMaterial.AdvertisBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping( "/advertismaterial")
public class AdvertisBrandController {

    @Autowired
    private AdvertisBrandService advertisBrandService;

    //  查看出所有的广告模板信息和搜索出相应的广告
    @GetMapping( "/brandManager")
    public Result searchAllAdvertis ( String search )  {
        try {
            List<AdvertisBrand> advertisBrands = advertisBrandService.searchAllBrand( search ) ;
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
            advertisBrandService.addBrandAdvertis( addBrand ); ;
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
            Map<String, Object> advertisBrand = advertisBrandService.showBrandAdvertis(id);
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
            advertisBrandService.updateBrandAdvertis( brandAdvertis );
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
            advertisBrandService.deleteBrandAdvertis( id ) ;
            return new Result(  "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

}
