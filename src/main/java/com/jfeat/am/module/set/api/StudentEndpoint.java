package com.jfeat.am.module.set.api;
    
                                            
                    import com.jfeat.crud.plus.META;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import com.baomidou.mybatisplus.plugins.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.dao.DuplicateKeyException;
import com.jfeat.crud.base.tips.SuccessTip;
import com.jfeat.crud.base.tips.Ids;
import com.jfeat.crud.base.tips.Tip;
import com.jfeat.am.module.log.annotation.BusinessLog;
import com.jfeat.crud.base.exception.BusinessCode;
import com.jfeat.crud.base.exception.BusinessException;
import com.jfeat.crud.plus.CRUDObject;
import java.math.BigDecimal;

import com.jfeat.am.module.set.services.domain.service.StudentService;
import com.jfeat.am.module.set.services.domain.model.StudentRecord;
import com.jfeat.am.module.set.services.gen.persistence.model.Student;

        import org.springframework.web.bind.annotation.RestController;
        
import javax.annotation.Resource;
import java.util.Date;


/**
 * <p>
 *  api
 * </p>
 *
 * @author Code Generator
 * @since 2019-10-29
 */
@RestController

@Api("Student")
@RequestMapping("/api/crud/set/students")
public class StudentEndpoint {



@Resource
    StudentService studentService;

@BusinessLog(name = "Student", value = "create Student")
@PostMapping
@ApiOperation(value = "新建 Student",response = Student.class)
public Tip createStudent(@RequestBody Student entity){

        Integer affected=0;
        try{
                affected= studentService.createMaster(entity);
    
        }catch(DuplicateKeyException e){
        throw new BusinessException(BusinessCode.DuplicateKey);
        }

        return SuccessTip.create(affected);
        }

@BusinessLog(name = "Student", value = "查看 Student")
@GetMapping("/{id}")
@ApiOperation(value = "查看 Student",response = Student.class)
public Tip getStudent(@PathVariable Long id){
                return SuccessTip.create(studentService.retrieveMaster(id));
            }

@BusinessLog(name = "Student", value = "update Student")
@PutMapping("/{id}")
@ApiOperation(value = "修改 Student",response = Student.class)
public Tip updateStudent(@PathVariable Long id,@RequestBody Student entity){
        entity.setId(id);
                return SuccessTip.create(studentService.updateMaster(entity));
            }

@BusinessLog(name = "Student", value = "delete Student")
@DeleteMapping("/{id}")
@ApiOperation("删除 Student")
public Tip deleteStudent(@PathVariable Long id){
                return SuccessTip.create(studentService.deleteMaster(id));
            }

@BusinessLog(name = "Student", value = "select Student")
@ApiOperation(value = "Student 列表信息",response = StudentRecord.class)
@GetMapping
@ApiImplicitParams({
        @ApiImplicitParam(name= "pageNum", dataType = "Integer"),
        @ApiImplicitParam(name= "pageSize", dataType = "Integer"),
        @ApiImplicitParam(name= "search", dataType = "String"),
                                                                                        @ApiImplicitParam(name = "id", dataType = "Long"),
                                                                                            @ApiImplicitParam(name = "name", dataType = "String"),
                                                                                                    @ApiImplicitParam(name = "age", dataType = "Integer"),
                                                                                                            @ApiImplicitParam(name = "teacherId", dataType = "Long"),
                                @ApiImplicitParam(name = "orderBy", dataType = "String"),
                @ApiImplicitParam(name = "sort", dataType = "String")
            })
public Tip queryStudents(Page<StudentRecord> page,
@RequestParam(name = "pageNum", required = false, defaultValue = "1") Integer pageNum,
@RequestParam(name = "pageSize", required = false, defaultValue = "10") Integer pageSize,
@RequestParam(name = "search", required = false) String search,
                                                                                                                @RequestParam(name = "id", required = false) Long id,
                                                                                                                                @RequestParam(name = "name", required = false) String name,
                                                                                                                                        @RequestParam(name = "age", required = false) Integer age,
                                                                                                                                                @RequestParam(name = "teacherId", required = false) Long teacherId,
                                    @RequestParam(name = "orderBy", required = false) String orderBy,
        @RequestParam(name = "sort", required = false)  String sort) {
                    if(orderBy!=null&&orderBy.length()>0){
        if(sort!=null&&sort.length()>0){
        String pattern = "(ASC|DESC|asc|desc)";
        if(!sort.matches(pattern)){
        throw new BusinessException(BusinessCode.BadRequest.getCode(), "sort must be ASC or DESC");//此处异常类型根据实际情况而定
        }
        }else{
        sort = "ASC";
        }
        orderBy = "`"+orderBy+"`" +" "+sort;
        }
        page.setCurrent(pageNum);
        page.setSize(pageSize);

    StudentRecord record = new StudentRecord();
                                                                                    record.setId(id);
                                                                                        record.setName(name);
                                                                                        record.setAge(age);
                                                                                                record.setTeacherId(teacherId);
                    page.setRecords(this.studentService.findStudentPage(page, record, search, orderBy, null, null));

        return SuccessTip.create(page);
        }
        }
