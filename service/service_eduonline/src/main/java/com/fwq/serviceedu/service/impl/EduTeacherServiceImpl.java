package com.fwq.serviceedu.service.impl;

import com.fwq.serviceedu.entity.EduTeacher;
import com.fwq.serviceedu.mapper.EduTeacherMapper;
import com.fwq.serviceedu.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.fwq.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author fwq
 * @since 2020-11-10
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

//    @Autowired
//   private EduTeacherMapper TeacherMapper;
//
//   public Result removeById(String id){
//       int i = TeacherMapper.deleteById(id);
//       if(i>0){
//           return Result.success();
//       }else {
//           return Result.error();
//       }
//   }

}
