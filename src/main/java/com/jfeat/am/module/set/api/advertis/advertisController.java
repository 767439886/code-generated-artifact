package com.jfeat.am.module.set.api.advertis;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.services.advertisMaterial.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/advertis")
public class advertisController {

    @Autowired
    private BrandService brandService;

    @RequestMapping( "/searchAllAdvertis")
    public Result searchAllAdvertis ()  {
        try {
            List<AdvertisBrand> advertisBrands = brandService.searchAllBrand() ;
            return new Result( advertisBrands , "返回的数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "数据返回失败" , 500 ) ;
        }
    }

    @RequestMapping( "/test")
    public void test () {
        System.out.println( "已经输出了" ) ;
    }
}
