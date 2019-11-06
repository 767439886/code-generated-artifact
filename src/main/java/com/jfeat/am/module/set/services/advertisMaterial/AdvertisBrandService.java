package com.jfeat.am.module.set.services.advertisMaterial;

import com.jfeat.am.module.set.mapper.advertisMaterial.AdvertisBrandMapper;
import com.jfeat.am.module.set.mapper.advertisMaterial.AreaMapper;
import com.jfeat.am.module.set.mapper.advertisMaterial.TypeMapper;
import com.jfeat.am.module.set.model.AdvertisBrand;
import com.jfeat.am.module.set.model.Area;
import com.jfeat.am.module.set.model.Type;
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
    private TypeMapper typeMapper ;

    public List<AdvertisBrand> searchAllBrand ( String search ) {
        Map<String, String> map = new HashMap<>() ;
        //  搜索出来的关键字
        if ( search != null ) {
            map.put("search", "%" + search + "%");
        }
        List<AdvertisBrand> advertisBrands = brandMapper.searchAdvertisBrand( map ) ;
        for ( int i = 0 ; i < advertisBrands.size() ; i++ ) {
            StringBuilder typeName = new StringBuilder("") ;
            //  返回搜索出来的区域名字
            String type = this.getAdvertisArea(advertisBrands.get(i).getTypeId() , typeName) ;
            //  把区域放进广告模板中
            advertisBrands.get(i).setType( type ); ;
        }
        return advertisBrands ;
    }

    //  返回该模板的类型
    public String getAdvertisArea( String parentId , StringBuilder typeName ) {
        //  判断他的父id是否为0
        if ( parentId.equals( "0" )  ) {
            return typeName.toString() ;
        } else {
            //  搜索出属于该id的地点
            List<Type> types = typeMapper.SearchType(parentId) ;
            //  把类型进行相加
            StringBuilder typeNameConnect = new StringBuilder(types.get(0).getType() ) ;
            typeName = typeNameConnect.append( typeName ) ;
            //  循环调用
            String advertisArea = this.getAdvertisArea("" + types.get(0).getParentId() , typeName  ) ;
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
        Map<String, Object> map = new HashMap<>() ;
        //  根据id搜索出对应的二级分类
        map.put( "second" , advertisBrands.get(0).getTypeId() ) ;
        List<Type> sconeds = typeMapper.SearchType( advertisBrands.get(0).getTypeId() ) ;
        //  根据二级分类搜索出一级分类
        map.put( "second" , sconeds.get(0).getParentId() ) ;
        List<Type> firsts = typeMapper.SearchAllType(map) ;
        //  把所有数据进行封装
        map.put( "id" , advertisBrands.get(0).getId() ) ;
        map.put( "first" , firsts.get(0).getType() ) ;
        map.put( "second" , sconeds.get(0).getType() ) ;
        map.put( "brandName" , advertisBrands.get(0).getAdvertisingName() ) ;
        map.put( "format" , advertisBrands.get(0).getFormat() ) ;
        map.put( "iftranscoding" , advertisBrands.get(0).getIftranscoding() ) ;
        return map ;
    }

    //  修改品牌数据
    public void updateBrandAdvertis( Map<String,String> map ) {
        this.deleteBrandAdvertis( map.get("id") ) ;
        AdvertisBrand advertisBrand = new AdvertisBrand() ;

        //   把数据进行封装
        advertisBrand.setTypeId( map.get("second") ); ;
        advertisBrand.setAdvertisingName( map.get("brandName") ) ;
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
