package com.jfeat.am.module.set.mapper.advertisMaterial;

import com.jfeat.am.module.set.model.Area;
import java.util.List;

public interface AreaMapper {
    public List<Area> SearchArea( String id ) ;
    public List<Area> SearchParentCity () ;
}
