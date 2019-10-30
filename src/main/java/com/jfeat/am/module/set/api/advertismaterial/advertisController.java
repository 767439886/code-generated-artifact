package com.jfeat.am.module.set.api.advertismaterial;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.services.advertisMaterial.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping( "/advertismaterial")
public class advertisController {

    @Autowired
    private BrandService brandService;

    //  查看出所有的广告模板信息
    @GetMapping( "/brandManager")
    public Result searchAllAdvertis ()  {
        try {
            List<AdvertisBrand> advertisBrands = brandService.searchAllBrand() ;
            return new Result( advertisBrands , "返回的数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "数据返回失败" , 500 ) ;
        }
    }

    //  增加广告的模板信息
//    public Result addAdvertis( @RequestBody AdvertisBrand advertisBrand ) {
//
//    }
}
