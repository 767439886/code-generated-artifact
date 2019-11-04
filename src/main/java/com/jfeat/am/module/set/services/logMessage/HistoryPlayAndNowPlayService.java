package com.jfeat.am.module.set.services.logMessage;

import com.jfeat.am.module.set.mapper.logMessage.HistoryPlayAndNowPlay;
import com.jfeat.am.module.set.model.Pushtimeadvertis;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class HistoryPlayAndNowPlayService {

    @Autowired( required = false )
    HistoryPlayAndNowPlay historyPlayAndNowPlay ;

    //  使用于查询现在的数据
    public List<Pushtimeadvertis> searchNowPlayAdvertis ( ) {
        List<Pushtimeadvertis> pushtimeadvertis = historyPlayAndNowPlay.searchNowPlayAdvertis() ;
        return pushtimeadvertis ;
    }

    //  使用于查询历史的数据
    public List<Pushtimeadvertis> searchHistoryPlayAdvertis () {
        List<Pushtimeadvertis> pushtimeadvertis = historyPlayAndNowPlay.searchHistoryPlayAdvertis() ;
        return pushtimeadvertis ;
    }
}
