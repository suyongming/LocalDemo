package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.ExcelDemoEntity;
import com.entity.User;
import com.entity.base.BaseEntity;
import com.exceptions.CustomException;
import com.util.ExcelUtils;
import com.util.RandomValue;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.sql.Timestamp;
import java.util.*;

@EnableEurekaClient
@RestController
@RequestMapping("/easyPOI")
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
     * 2.通用导出 根据RESTful风格 到处相关业务 的嵌套Excel 最终版
     *
     * @PathVariable pojo 要到处的业务模块
     * @Param conditions 动态条件 需要解密处理
     */
    //    @PostMapping("/export/{pojo}"),JSONObject conditions
    @GetMapping("/export/{pojo}")
    public void exportByService(
            @PathVariable(value="pojo") String pojoName,HttpServletResponse response){

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




//        ExcelUtils.exportExcel(list, "测试title", "sheet1", ExcelDemoEntity.class, "测试.xls", response);
    }

    private static List<User> getUserList() {
        List<User> list = new ArrayList();


        for (int i = 0; i < 20; i++) {
            Map ranObj = RandomValue.getAddress();
            User user = new User();

            user.setUserId(UUID.randomUUID().toString());
            user.setUserName(ranObj.get("email")+"");
            user.setPassword("******");
            user.setLastModifyTime(new Date());
            user.setCreate(new Date());
            list.add(user);

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
