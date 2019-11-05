package com.jfeat.am.module.set.mapper.terminal;


import com.jfeat.am.module.set.model.Terminalmanager;
import java.util.List;
import java.util.Map;

public interface TerminalManagerMapper {

    //  搜索的要推送的终端
    public List<Terminalmanager> searchTerminal ( String id ) ;
    //  增加终端
    public void addTeriminal(Map<String,Object> teriminalManager ) ;
    //  删除终端
    public void deleteTerminal ( String id ) ;
    //  修改终端
    public void updateTerminalManager ( Terminalmanager terminalmanager ) ;
}
