package com.jfeat.am.module.set.mapper.advertisMaterial;
import com.jfeat.am.module.set.model.AdvertisBrand;
import java.util.List;

public interface AdvertisBrandMapper {
    //  搜索出所有的模板
    public List<AdvertisBrand> searchAdvertisBrand( String id ) ;
    //  增加模板
    public void addBrand( AdvertisBrand advertisBrand ) ;
    public void addBrandAndId ( AdvertisBrand advertisBrand ) ;
    //  删除模板
    public void deleteBrandAdvertis ( String id ) ;
}
