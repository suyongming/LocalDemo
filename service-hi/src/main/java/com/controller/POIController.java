package com.controller;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

@RestController
public class POIController {



    public static void createExcel(String excelName) throws Exception {

        //创建工作簿
        XSSFWorkbook wb = new XSSFWorkbook();
        //创建一个sheet
        XSSFSheet sheet = wb.createSheet();

        // 创建单元格样式
        XSSFCellStyle style =  wb.createCellStyle();
        style.setFillPattern(FillPatternType.SOLID_FOREGROUND); //solid 填充
        style.setAlignment(XSSFCellStyle.ALIGN_CENTER); //文字水平居中
        style.setVerticalAlignment(XSSFCellStyle.VERTICAL_CENTER);//文字垂直居中
        style.setBorderBottom(BorderStyle.THIN); //底边框加黑
        style.setBorderLeft(BorderStyle.THIN);  //左边框加黑
        style.setBorderRight(BorderStyle.THIN); // 有边框加黑
        style.setBorderTop(BorderStyle.THIN); //上边框加黑
        //为单元格添加背景样式
        for (int i = 0; i < 6; i++) { //需要6行表格
            Row row =	sheet.createRow(i); //创建行
            for (int j = 0; j < 13; j++) {//需要6列
                row.createCell(j).setCellStyle(style);
            }
        }

        // 设置字体
        XSSFFont font = wb.createFont();
        font.setFontHeightInPoints((short) 20); //字体高度
        font.setColor(HSSFFont.COLOR_RED); //字体颜色
        font.setFontName("黑体"); //字体
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD); //宽度
//        font.setStrikeout(true); //是否使用划线


        //合并单元格
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 4));//合并单元格，cellRangAddress四个参数，第一个起始行，第二终止行，第三个起始列，第四个终止列
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 5, 12));

        //tian入数据
        XSSFRow row = sheet.getRow(0); //获取第一行
        row.getCell(0).setCellValue("团检信息"); //在第一行中创建一个单元格并赋值
        row.getCell(5).setCellValue("员工信息");

        XSSFRow row1 = sheet.getRow(1); //获取第二行，为每一列添加字段

        row1.getCell(0).setCellValue("企业名称");
        row1.getCell(1).setCellValue("项目代码");
        row1.getCell(2).setCellValue("项目名称");
        row1.getCell(3).setCellValue("分组代码");
        row1.getCell(4).setCellValue("分组名称");
        row1.getCell(5).setCellValue("身份证");
        row1.getCell(6).setCellValue("姓名");
        row1.getCell(7).setCellValue("手机号");
        row1.getCell(8).setCellValue("性别");
        row1.getCell(9).setCellValue("婚姻");
        row1.getCell(10).setCellValue("出生日期");
        row1.getCell(11).setCellValue("年龄");
        row1.getCell(12).setCellValue("工号");






        //将数据写入文件
        FileOutputStream out = new FileOutputStream(excelName);
        wb.write(out);

    }
    public static void main(String[] args) throws Exception {
        POIController.createExcel("e:/poi/haha8.xlsx");
//        POIController.readExcel("haha");
    }
    public static void readExcel(String excelName) throws IOException {

        //将文件读入
        InputStream in  = new FileInputStream(new File("C:\\Users\\Administrator\\Desktop\\etong\\团检人员导入模板.xlsx"));
        //创建工作簿
        XSSFWorkbook wb = new XSSFWorkbook(in);
        //读取第一个sheet
        Sheet sheet = wb.getSheetAt(0);
        //获取第二行
//        Row row = sheet.getRow(2);
//        //循环读取科目
//        for (int i = 1; i < 14; i++) {
//
//            System.out.println(row.getCell(i));
//        }
        for(int i=2;i<sheet.getLastRowNum()+1;i++){
            System.out.print("第"+i+" 行:");

            Row row = sheet.getRow(i);

            for (int j = 0; j < 15; j++){
                //0.企业代码*	1企业名称*	2项目代码*	3项目名称*	4分组代码*	5分组名称*	6身份证*	7姓名*	8手机号*	9性别*
                // 10婚姻	11出生日期*	12年龄	13批次
//				System.out.print(row.getCell(j)+"  ");
                if(j == 6){
                    //1.校验每一条身份证是否合法
                    String checkSex = Integer.parseInt(row.getCell(j).toString().substring(16,17))%2==1?"男":"女";
                    System.out.println("真实身份证:"+checkSex);
                    System.out.println("录入的性别："+row.getCell(9));
                    if(checkSex.trim().equals(row.getCell(9).toString().trim())){
                        System.out.println("对的");
                    }else{
                        System.out.println("错的");

                    }


                }
                if(j == 15){
                    System.out.println("工号："+row.getCell(14));
                }
            }
            System.out.println();

        }
    }
}
