package com.jfeat.am.module.set.services.advertisMaterial;
import com.jfeat.am.module.set.mapper.advertisMaterial.AreaMapper;
import com.jfeat.am.module.set.model.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class AreaService {

    @Autowired( required =  false )
    private AreaMapper areaMapper ;

    //  返回所有城市供用户选择
    public List<Area> searchParentArea () {
        List<Area> areas = areaMapper.SearchParentCity() ;
        return areas ;
    }
}
