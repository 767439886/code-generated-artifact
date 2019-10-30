package com.jfeat.am.module.set.services.domain.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.jfeat.am.module.set.services.domain.model.StudentRecord;
import com.jfeat.am.module.set.services.gen.crud.service.CRUDStudentService;

import java.util.Date;
import java.util.List;

/**
 * Created by vincent on 2017/10/19.
 */
public interface StudentService extends CRUDStudentService{
    List findStudentPage(Page<StudentRecord> page, StudentRecord record, String search,
                           String orderBy, Date startTime, Date endTime);
}