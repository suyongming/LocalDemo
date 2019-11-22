package com.entity.base;

import com.exceptions.CustomException;
import com.util.ClassUtils;
import lombok.Data;

import java.io.Serializable;
import java.util.*;

@Data
public class BaseEntity implements Serializable {

    final static String CLASS_PATH = BaseEntity.class.getPackage().getName();

    /**
     * 获取BaseEntity的上一层目录
     */
    public static String getSuperior() {
        return CLASS_PATH.substring(0, CLASS_PATH.lastIndexOf('.'));
    }

    ;

    /**
     * 获取所有entity目录下的CLASS
     *
     * @Param recursive 根据 recursive 控制是否递归
     */
    private static Set<Class<?>> findAllEntityClazz(boolean recursive) {
        return ClassUtils.getClassesByRecursion(getSuperior(), recursive);
    }

    /**
     * @Param pojo 业务的PathVariable，用于命中目录下的entity
     * @Return class 对应业务的class对象
     */
    public static Class getClassByPojoName(String pojoName, boolean recursive) throws CustomException {
        Set<Class<?>> classSet = findAllEntityClazz(recursive);
        List<Class<?>> classTemp = new ArrayList<>();

        String index1 = pojoName.substring(0, 1).toUpperCase();
        String toUpPojoName = index1 + pojoName.substring(1);

        classSet.forEach(clazz -> {
            //命中
            if (toUpPojoName.equals(clazz.getSimpleName())) {
                classTemp.add(clazz);
            }
        });

        if (classTemp.isEmpty()) {
            throw new CustomException("不存在该模块");
        }

        return classTemp.get(0);
    }

    public static void main(String[] args) {
        Set<Class<?>> classSet = ClassUtils.getClassesByRecursion(getSuperior(), false);

        classSet.forEach(clazz -> {
            System.out.println(clazz.getSimpleName());
        });


    }


}
