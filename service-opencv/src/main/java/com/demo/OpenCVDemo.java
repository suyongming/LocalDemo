package com.demo;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class OpenCVDemo {

        static {
            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
            //注意程序运行的时候需要在VM option添加该行 指明opencv的dll文件所在路径
            //-Djava.library.path=$PROJECT_DIR$\opencv\x64
        }
        public static void main(String[] args){


        }

    //            Mat mat = Imgcodecs.imread("E:\\图片\\表情\\xxydx.jpg");
//            String imgPath = "E:\\图片\\表情\\xxydx";
//            Mat mat = Imgcodecs.imread(imgPath+".jpg");
//            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//            Mat image = Imgcodecs.imread(imgPath+".jpg");
//            Imgproc.cvtColor(image, image, Imgproc.COLOR_RGB2GRAY);
//            Imgproc.adaptiveThreshold(image, image, 255, Imgproc.ADAPTIVE_THRESH_MEAN_C, Imgproc.THRESH_BINARY_INV, 25, 10);
//            Imgcodecs.imwrite(imgPath+"openCV.jpg", image);
//            System.out.println(mat);
//            System.out.println(mat);

}
