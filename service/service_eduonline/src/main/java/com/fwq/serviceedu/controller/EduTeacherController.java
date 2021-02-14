package com.fwq.serviceedu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fwq.serviceedu.entity.EduTeacher;
import com.fwq.serviceedu.service.EduTeacherService;
import com.fwq.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author fwq
 * @since 2020-11-10
 */
@Slf4j
@Api(description = "讲师管理接口")
@RestController
@RequestMapping("/admin/edu/teachers")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    /**
     * 所有讲师列表接口
     * */
    @ApiOperation(value = "所有讲师列表")
    @GetMapping
    public Result list(){
        List<EduTeacher> list = teacherService.list(null);
        return Result.success().data("teachers",list);
    }
    /**
     * 删除讲师接口
     * */
    @ApiOperation(value = "根据ID删除讲师")
    @DeleteMapping("{id}")
    public Result delTeacherById( @ApiParam(name = "id", value = "讲师ID", required = true)@PathVariable String id){
        boolean flag = teacherService.removeById(id);
        if(flag){
            return Result.success();
        }else{

            return Result.error();
        }
    }

    /**
     * 讲师分页查询接口
     * */
    @ApiOperation(value = "讲师分页列表")
    @GetMapping("{page}/{limit}")
    public Result pageList(
            @ApiParam(name = "page",value ="当前页码",required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit",value ="每页记录数",required = true)
            @PathVariable Long limit){
        int i = (int) (page/limit);
        Page<EduTeacher> teacherPage = new Page<>(page,limit);
        teacherService.page(teacherPage, null);
        List<EduTeacher> records = teacherPage.getRecords();
        long total = teacherPage.getTotal();
        return Result.success().data("total",total).data("teachers",records);
    }

    /**
     *
     * 新增讲师接口
     * */

    @ApiOperation(value = "新增讲师")
    @PostMapping
    public Result addTeacher(@ApiParam(name = "teacher",value = "讲师对象",required = true) @RequestBody EduTeacher teacher){
        boolean flag = teacherService.save(teacher);
        if(flag){
            return Result.success();
        }else{
            return Result.error();
        }
    }

    /**
     * 根据id查询讲师接口
     * */
    @ApiOperation(value = "根据id查询讲师")
    @GetMapping("{id}")
    public Result selectById(@ApiParam(name = "id",value = "讲师ID",required = true) @PathVariable String id){
        EduTeacher teacher = teacherService.getById(id);
        return Result.success().data("teacher",teacher);
    }

    /**
     * 根据id修改讲师接口
     * */
    @ApiOperation(value = "根据id修改讲师")
    @PutMapping("{id}")
    public Result updateById(@ApiParam(name = "id",value = "讲师ID",required = true) @PathVariable String id,
                             @ApiParam(name = "teacher",value = "讲师对象",required = true) @RequestBody EduTeacher teacher){
        teacher.setId(id);
        teacherService.updateById(teacher);
        return Result.success();
    }

}

