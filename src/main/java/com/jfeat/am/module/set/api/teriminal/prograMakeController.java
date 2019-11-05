package com.jfeat.am.module.set.api.teriminal;

import com.jfeat.am.module.set.common.Result;
import com.jfeat.am.module.set.model.Programake;
import com.jfeat.am.module.set.services.showTemplate.PrograMakeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping( "/showTelemplate/prograMake" )
public class prograMakeController {

    @Autowired( required = false )
    private PrograMakeService prograMakeService ;

    //  终端的数据搜索成功
    @GetMapping()
    public Result SearchterminalManager ( ) {
        try {
            List<Programake> terminalmanagers = prograMakeService.SearchPrograMake() ;
            return new Result( terminalmanagers ,   "返回的数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "返回数据失败" , 500 ) ;
        }
    }

    //  使用于增加字段
    @PostMapping()
    public Result addTerminalManager ( @RequestBody Programake program ) {
        try {
            prograMakeService.addPrograMake( program ); ;
            return new Result( "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace() ;
            return new Result( "增加数据失败" , 500 ) ;
        }
    }

    //  删除终端信息
    @DeleteMapping( "/{id}")
    public Result deleteTerminalManager (@PathVariable String id ) {
        try {
            prograMakeService.deletePrograMake(id); ;
            return new Result( "删除数据成功" , 200 ) ;
        } catch ( Exception e) {
            return new Result( "删除数据失败" , 500 ) ;
        }
    }

    //  返回终端的属性
    @GetMapping ( "/{id}")
    public Result showTerminalManager (@PathVariable String id ) {
        try {
            //  得到要输出的数
            Programake programake = prograMakeService.showPrograMake(id) ;
            return new Result( programake , "删除数据成功" , 200 ) ;
        } catch ( Exception e) {
            e.printStackTrace();
            return new Result( "删除数据失败" , 500 ) ;
        }
    }

    //  把修改后的数据输入数据库
    @PutMapping( "/{id}")
    public Result saveTerminalManager( String id  , @RequestBody Programake programake ) {
        try {
            prograMakeService.updatePrograMake( programake );
            return new Result(  "增加数据成功" , 200 ) ;
        } catch ( Exception e ) {
            e.printStackTrace();
            return new Result( "增加数据失败" , 500 ) ;
        }
    }
}
