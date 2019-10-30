package com.jfeat.am.module.set.services.domain.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.set.services.domain.dao.QueryStudentDao;
import com.jfeat.am.module.set.services.domain.model.StudentRecord;
import com.jfeat.am.module.set.services.domain.service.StudentService;
import com.jfeat.am.module.set.services.gen.crud.service.impl.CRUDStudentServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2017-10-16
 */
@Service("studentService")
public class StudentServiceImpl extends CRUDStudentServiceImpl implements StudentService {
    @Resource
    QueryStudentDao queryStudentDao;

    @Override
    public List findStudentPage(Page<StudentRecord> page, StudentRecord record,
                                  String search, String orderBy, Date startTime, Date endTime) {
        List recordList = this.queryStudentDao.findStudentPage(page, record, search, orderBy, startTime, endTime);
        return this.getEavProxy().selectList(recordList, this.entityName());
    }
}
