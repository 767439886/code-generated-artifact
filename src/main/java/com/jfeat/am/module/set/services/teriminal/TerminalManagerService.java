package com.jfeat.am.module.set.services.teriminal;

import com.jfeat.am.module.set.mapper.advertisMaterial.AreaMapper;
import com.jfeat.am.module.set.mapper.terminal.TerminalManagerMapper;
import com.jfeat.am.module.set.model.Area;
import com.jfeat.am.module.set.model.Terminalmanager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Transactional
@Service
public class TerminalManagerService {

    @Autowired(  required =  false )
    TerminalManagerMapper terminalManagerMapper ;
    @Autowired( required =  false )
    AreaMapper areaMapper ;

    public void addTerminalManager(Map<String,Object> terminalManager ) {
        //   增加终端管理
        terminalManagerMapper.addTeriminal( terminalManager ) ;
    }

    public List<Terminalmanager> SearchTerminalManager () {
        //  查询出所有的终端
        List<Terminalmanager> terminalmanagers = terminalManagerMapper.searchTerminal( null ) ;
        for ( int i = 0 ; i < terminalmanagers.size() ; i++ ) {
            // 得到区域的名字
            String area = terminalmanagers.get(i).getArea() ;
            // 根据区域的名字
            List<Area> areas = areaMapper.SearchArea(area) ;
            // 根据区域的名字查询城市的名字
            List<Area> citys = areaMapper.SearchArea(areas.get(0).getParentId() + "") ;
            area = citys.get(0).getCityName() + areas.get(0).getCityName() ;
            // 查询出城市和地区
            terminalmanagers.get(i).setArea( area );
        }
        return terminalmanagers ;
    }

    public void delectTerinalManager ( String id ) {
        //  删除指定的终端
        terminalManagerMapper.deleteTerminal( id )  ;
    }

    public List<Terminalmanager> showTerminalManager ( String id ) {
        List<Terminalmanager> terminalmanagers = terminalManagerMapper.searchTerminal(id) ;
        for ( int i = 0 ; i < terminalmanagers.size() ; i++ ) {
            Terminalmanager terminalmanager = terminalmanagers.get(i) ;
            //  搜索出所属的区
            List<Area> areas = areaMapper.SearchArea(terminalmanager.getArea() ) ;
            //  搜索出所属的市
            List<Area> city = areaMapper.SearchArea(areas.get(0).getParentId() + "") ;
            terminalmanagers.get(i).setArea( areas.get(0).getCityName() ) ;
            terminalmanagers.get(i).setCity( city.get(0).getCityName() );
        }
        return terminalmanagers ;
    }

    public void updateTerminalManager( Terminalmanager terminalmanager  ) {
        terminalManagerMapper.updateTerminalManager( terminalmanager ) ;
    }
}
