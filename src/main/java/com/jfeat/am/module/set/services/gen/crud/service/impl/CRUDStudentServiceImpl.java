package com.jfeat.am.module.set.services.gen.crud.service.impl;
            
import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.jfeat.crud.plus.FIELD;
import com.jfeat.am.module.set.services.gen.persistence.model.Student;
import com.jfeat.am.module.set.services.gen.persistence.dao.StudentMapper;
import com.jfeat.am.module.set.services.gen.crud.service.CRUDStudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import javax.annotation.Resource;
import com.jfeat.crud.plus.impl.CRUDServiceOnlyImpl;

/**
 * <p>
 *  implementation
 * </p>
 *CRUDStudentService
 * @author Code Generator
 * @since 2019-10-29
 */

@Service
public class CRUDStudentServiceImpl  extends CRUDServiceOnlyImpl<Student> implements CRUDStudentService {





        @Resource
        protected StudentMapper studentMapper;

        @Override
        protected BaseMapper<Student> getMasterMapper() {
                return studentMapper;
        }







}


