package com.jfeat.am.module.set.mapper.advertisMaterial;

import com.jfeat.am.module.set.model.Type;
import java.util.List;
import java.util.Map;

public interface TypeMapper {
    public List<Type> SearchType(String id ) ;
    public List<Type> SearchParentType () ;
    public List<Type> SearchAllType ( Map<String,Object> advertisBrand ) ;
}