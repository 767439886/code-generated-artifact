package com.jfeat.am.module.set.api.advertismaterial;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.Area;

import com.jfeat.am.module.set.services.advertisMaterial.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/advertismaterial")
public class areaController {

    @Autowired
    private AreaService areaService ;

    @GetMapping( "/area" )
    public Result searchArea( ) {
        try {
            //  返回城市区域
            List<Area> areas = areaService.searchParentArea();
            return new Result( areas , "返回成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "返回失败" , 500 ) ;
        }
    }
}
