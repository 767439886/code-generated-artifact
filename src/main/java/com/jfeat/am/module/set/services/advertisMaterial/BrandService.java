package com.jfeat.am.module.set.services.advertisMaterial;
import com.jfeat.am.module.set.mapper.advertisMaterial.BrandMapper;
import com.jfeat.am.module.set.model.AdvertisBrand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class BrandService {

    @Autowired( required = false )
    private BrandMapper brandMapper ;

    public List<AdvertisBrand> searchAllBrand () {
        List<AdvertisBrand> advertisBrands = brandMapper.searchAdvertisBrand() ;
        return advertisBrands ;
    }
}
