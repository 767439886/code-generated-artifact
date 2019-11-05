package com.jfeat.am.module.set.services.showTemplate;

import com.jfeat.am.module.set.mapper.advertisMaterial.AreaMapper;
import com.jfeat.am.module.set.mapper.terminal.PrograMakeMapper;
import com.jfeat.am.module.set.model.Area;
import com.jfeat.am.module.set.model.Programake;
import com.jfeat.am.module.set.model.Terminalmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class PrograMakeService {

    @Autowired( required = false )
    private PrograMakeMapper prograMakeMapper ;
    @Autowired( required = false)
    private AreaMapper areaMapper ;

    public List<Programake> SearchPrograMake () {
        //   搜索出对应的节目制造
        List<Programake> programakes = prograMakeMapper.SearchPrograMake( null ) ;
        for ( int i = 0 ; i < programakes.size() ; i++ ) {
            // 得到区域的名字
            String area = programakes.get(i).getArea() ;
            // 根据区域的名字
            List<Area> areas = areaMapper.SearchArea(area) ;
            // 根据区域的名字查询城市的名字
            List<Area> citys = areaMapper.SearchArea(areas.get(0).getParentId() + "") ;
            area = citys.get(0).getCityName() + areas.get(0).getCityName() ;
            // 查询出城市和地区
            programakes.get(i).setArea( area ) ;
        }
        return programakes ;
    }
    //  增加节目制造
    public void addPrograMake ( Programake programake ) {
        prograMakeMapper.addPrograMake( programake ) ;
    }
    public void deletePrograMake ( String id ) {
        //  根据id删除节目制造
        prograMakeMapper.deletePrograMake( id ) ;
    }
    public Programake showPrograMake ( String id ) {
        List<Programake> programakes = prograMakeMapper.SearchPrograMake(id) ;
        for ( int i = 0 ; i < programakes.size() ; i++ ) {
            Programake programake = programakes.get(i) ;
            //  搜索出所属的区
            List<Area> areas = areaMapper.SearchArea(programake.getArea() ) ;
            //  搜索出所属的市
            List<Area> city = areaMapper.SearchArea(areas.get(0).getParentId() + "") ;
            programakes.get(i).setArea( areas.get(0).getCityName() ) ;
            programakes.get(i).setCity( city.get(0).getCityName() );
        }
        return programakes.get(0) ;
    }
    public void updatePrograMake( Programake programake ) {
        this.deletePrograMake( programake.getId().toString());
        prograMakeMapper.addPrograMakeAndId( programake ) ;
    }
}
