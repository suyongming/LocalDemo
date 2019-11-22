package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.ExcelDemoEntity;
import com.entity.UserEntity;
import com.entity.base.BaseEntity;
import com.exceptions.CustomException;
import com.util.ExcelUtils;
import com.util.RandomValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.*;

@EnableEurekaClient
@RestController
@RequestMapping("/easyPOI")
@Slf4j
public class EasyPOIController {

    /**
     * 1.普通easyPOI导出
     */
    @GetMapping("/export")
    public void export(HttpServletResponse response) {
        List<ExcelDemoEntity> list = getDemoList();

        ExcelUtils.exportExcel(list, "测试title", "sheet1", ExcelDemoEntity.class, "测试.xls", response);

    }

    /**
     * 2.通用导出 根据RESTful风格 导出相关业务 的嵌套Excel 最终版
     *
     * @PathVariable pojo 要导出的业务模块
     * @Param conditions 动态条件 需要解密处理
     */
    //    @PostMapping("/export/{pojo}")
    @PostMapping("/export/{pojo}")
    public void exportByService(
            @PathVariable(value="pojo") String pojoName,
            @RequestBody JSONObject conditions,
            HttpServletResponse response){

        if(!conditions.isEmpty()){
            log.info(conditions.toJSONString());
            return;
        }

        Class clazz = null;
        try {

            clazz = BaseEntity.getClassByPojoName(pojoName,false);

            //1.0.0根据 conditions 获得 list
            List list = getDemoList();//假数据
//            List<User> userList = getUserList();



            //2.0.0
            ExcelUtils.exportExcel(list, "测试title", "sheet1", clazz, "测试.xls", response);

        } catch (CustomException e) {
            e.printStackTrace();
        }

    }

    private static List<UserEntity> getUserList() {
        List<UserEntity> list = new ArrayList();


        for (int i = 0; i < 20; i++) {
            Map ranObj = RandomValue.getAddress();
            UserEntity userEntity = new UserEntity();

            userEntity.setUserId(UUID.randomUUID().toString());
            userEntity.setUserName(ranObj.get("email")+"");
            userEntity.setPassword("******");
            userEntity.setLastModifyTime(new Date());
            userEntity.setCreate(new Date());
            list.add(userEntity);

        }
        return list;
    }

    private static List<ExcelDemoEntity> getDemoList() {
        List<ExcelDemoEntity> list = new ArrayList();


        for (int i = 0; i < 20; i++) {
            Map ranObj = RandomValue.getAddress();
            ExcelDemoEntity excelDemoEntity = JSONObject.parseObject(ranObj.toString(),ExcelDemoEntity.class);
            excelDemoEntity.setId(UUID.randomUUID().toString());
            excelDemoEntity.setCreateTime(new Date());
            list.add(excelDemoEntity);

        }
        return list;
    }

    public static void main(String[] args) {

    }
}
