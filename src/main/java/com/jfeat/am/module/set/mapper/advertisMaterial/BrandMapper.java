package com.jfeat.am.module.set.mapper.advertisMaterial;
import com.jfeat.am.module.set.model.AdvertisBrand;
import java.util.List;

public interface BrandMapper {
    //  搜索出所有的模板
    public List<AdvertisBrand> searchAdvertisBrand() ;
    //  增加模板
    public void addBrand( AdvertisBrand advertisBrand ) ;
}
