package com.jfeat.am.module.set.services.advertisMaterial;

import com.jfeat.am.module.set.mapper.advertisMaterial.AdvertisBrandMapper;
import com.jfeat.am.module.set.mapper.advertisMaterial.AreaMapper;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service
public class AdvertisBrandService {

    @Autowired( required = false )
    private AdvertisBrandMapper brandMapper ;
    @Autowired( required = false )
    private AreaMapper areaMapper ;

    public List<AdvertisBrand> searchAllBrand ( String search ) {
        Map<String, String> map = new HashMap<>() ;
        //  搜索出来的关键字
        if ( search != null ) {
            map.put("search", "%" + search + "%");
        }
        List<AdvertisBrand> advertisBrands = brandMapper.searchAdvertisBrand( map ) ;
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

    //  使用于增加品牌的数据
    public void addBrandAdvertis( AdvertisBrand advertisBrand ) {
        // 增加广告的品牌
        brandMapper.addBrand( advertisBrand ) ;
    }

    //  回显品牌的数据 , 返回搜索到关联id的品牌
    public Map<String,Object> showBrandAdvertis( String id ) {
        Map<String,String> keyword = new HashMap<>();
        keyword.put("id" , id ) ;
        //  搜索出关联的品牌
        List<AdvertisBrand> advertisBrands = brandMapper.searchAdvertisBrand(keyword) ;

        //  再搜索出城市和区
        Map<String, Object> map = new HashMap<>() ;
        map.put( "area" , advertisBrands.get(0).getCategoryId() ) ;
        //  根据id搜索出对应的区
        List<Area> areas = areaMapper.SearchCity(map) ;
        //  根据区的父id搜索出市
        map.put( "area" , areas.get(0).getParentId() ) ;
        List<Area> citys = areaMapper.SearchCity(map) ;

        //  把所有数据进行封装
        map.put( "id" , advertisBrands.get(0).getId() ) ;
        map.put( "city" , citys.get(0).getCityName() ) ;
        map.put( "area" , areas.get(0).getCityName() ) ;
        map.put( "advertisingName" , advertisBrands.get(0).getAdvertisingName() ) ;
        map.put( "format" , advertisBrands.get(0).getFormat() ) ;
        map.put( "iftranscoding" , advertisBrands.get(0).getIftranscoding() ) ;
        return map ;
    }

    //  修改品牌数据
    public void updateBrandAdvertis( Map<String,String> map ) {
        this.deleteBrandAdvertis( map.get("id") ) ;
        AdvertisBrand advertisBrand = new AdvertisBrand() ;

        //   把数据进行封装
        advertisBrand.setCategoryId( map.get("area") ); ;
        advertisBrand.setAdvertisingName( map.get("advertisingName") ) ;
        advertisBrand.setFormat( map.get("format") ); ;
        advertisBrand.setIftranscoding( map.get("iftranscoding") ) ;
        advertisBrand.setId( Integer.parseInt(map.get("id")) ) ;
        brandMapper.addBrandAndId( advertisBrand ) ;
    }

    //  删除品牌数据
    public void deleteBrandAdvertis( String id ) {
        brandMapper.deleteBrandAdvertis(id) ;
    }
}
