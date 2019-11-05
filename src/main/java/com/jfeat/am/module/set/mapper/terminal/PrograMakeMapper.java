package com.jfeat.am.module.set.mapper.terminal;

import com.jfeat.am.module.set.model.Programake;
import java.util.List;

public interface PrograMakeMapper {

    //   搜索出所有的节目制造
    public List<Programake> SearchPrograMake ( String id ) ;
    //   保存节目的制造
    public void addPrograMake( Programake programake ) ;
    //   删除节目
    public void deletePrograMake ( String id ) ;
    //   增加节目
    public void addPrograMakeAndId ( Programake programake ) ;
}
