package com.jfeat.am.module.set.services.advertisMaterial;
import com.jfeat.am.module.set.mapper.advertisMaterial.AreaMapper;
import com.jfeat.am.module.set.mapper.advertisMaterial.BrandMapper;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class BrandService {

    @Autowired( required = false )
    private BrandMapper brandMapper ;
    @Autowired( required = false )
    private AreaMapper areaMapper ;

    public List<AdvertisBrand> searchAllBrand () {
        List<AdvertisBrand> advertisBrands = brandMapper.searchAdvertisBrand() ;
        for ( int i = 0 ; i < advertisBrands.size() ; i++ ) {
            StringBuilder cityName = new StringBuilder("") ;
            //  返回搜索出来的区域名字
            String advertisArea = this.getAdvertisArea(advertisBrands.get(i).getCategoryId(), cityName) ;
            //  把区域放进广告模板中
            advertisBrands.get(i).setArea( advertisArea ) ;
        }
        return advertisBrands ;
    }

    //  返回该模板属于的城市和区
    public String getAdvertisArea( String parentId , StringBuilder areaName ) {
        //  判断他的父id是否为0
        if ( parentId.equals( "0" )  ) {
            return areaName.toString() ;
        } else {
            //  搜索出属于该id的地点
            List<Area> areas = areaMapper.SearchArea(parentId) ;
            //  把地点进行相加
            StringBuilder cityName = new StringBuilder(areas.get(0).getCityName()) ;
            areaName = cityName.append( areaName ) ;
            //  循环调用
            String advertisArea = this.getAdvertisArea("" + areas.get(0).getParentId(), areaName) ;
            //  返回区域
            return advertisArea ;
        }
    }

    public void addAllBrand() {

    }
}
