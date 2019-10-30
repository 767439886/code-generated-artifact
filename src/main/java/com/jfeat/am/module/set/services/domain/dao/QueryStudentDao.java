package com.jfeat.am.module.set.services.domain.dao;

import com.jfeat.am.module.set.services.domain.model.StudentRecord;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import com.jfeat.am.module.set.services.gen.persistence.model.Student;
import java.util.Date;
import java.util.List;

/**
 * Created by Code Generator on 2019-10-29
 */
public interface QueryStudentDao extends BaseMapper<Student> {
    List<StudentRecord> findStudentPage(Page<StudentRecord> page, @Param("record") StudentRecord record,
                                            @Param("search") String search, @Param("orderBy") String orderBy,
                                            @Param("startTime") Date startTime, @Param("endTime") Date endTime);
}