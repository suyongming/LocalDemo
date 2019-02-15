package com.util;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Rect;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.videoio.VideoCapture;
import org.opencv.videoio.Videoio;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.PrintWriter;
import java.io.StringWriter;

public class OpenCVUtil extends JPanel{
    private BufferedImage mImg;


    static final String OUT_PATH ="F:\\face\\";

//    static{
//        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
//    }
    /**
     * 转换图像
     * @param mat
     * @return
     */
    private BufferedImage mat2BI(Mat mat){
        int dataSize = mat.cols()*mat.rows()*(int)mat.elemSize();
        byte[] data = new byte[dataSize];
        mat.get(0, 0,data);

        int type = mat.channels()==1? BufferedImage.TYPE_BYTE_GRAY:BufferedImage.TYPE_3BYTE_BGR;
        if(type == BufferedImage.TYPE_3BYTE_BGR){
            for(int i=0;i<dataSize;i+=3){
                byte blue=data[i+0];
                data[i+0]=data[i+2];
                data[i+2]=blue;
            }
        }
        BufferedImage image=new BufferedImage(mat.cols(),mat.rows(),type);
        image.getRaster().setDataElements(0, 0, mat.cols(), mat.rows(), data);

        return image;
    }

    /**
     * 打开摄像头
     * */
    public static void openVideo(){
        try{
            //加载opencv库
//            System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

            //获取摄像头视频流
            VideoCapture capture = new VideoCapture(0);
            int height = (int)capture.get(Videoio.CAP_PROP_FRAME_HEIGHT);
            int width = (int)capture.get(Videoio.CAP_PROP_FRAME_WIDTH);
            if(height == 0||width == 0){
                throw new Exception("camera not found!");
            }

            //使用Swing生成GUI
            JFrame frame = new JFrame("camera");
            frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            OpenCVUtil panel = new OpenCVUtil();
            frame.setContentPane(panel);
            frame.setVisible(true);
            frame.setSize(width+frame.getInsets().left+frame.getInsets().right,
                    height+frame.getInsets().top+frame.getInsets().bottom);

            Mat capImg = new Mat();
            //Random r = new Random();
            while(frame.isShowing()){
                //获取视频帧
                capture.read(capImg);
                //转为图像显示
                panel.mImg = panel.mat2BI(capImg);
                panel.repaint();
            }
            capture.release();
            frame.dispose();

        }catch(Exception e){
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            System.out.println(sw.toString());
        }
        finally{
            System.out.println("Exit");
        }
    }

    /**
     * 根据图片识别人脸
     * */

    /**
     * 处理为灰度图片
     * */
    private static void myCvtColor(String imgPath){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        Mat srcImage = Imgcodecs.imread(imgPath);
        Mat dstImage = new Mat();
        Imgproc.cvtColor(srcImage, dstImage, Imgproc.COLOR_BGR2GRAY,0);
        Imgcodecs.imwrite("F:\\face\\灰度冯伟强.jpg", dstImage);

    }

    /**
     * opencv将人脸进行截图并保存
     * @param img
     */
    private static void save(Mat img, Rect rect, String outFile){
        Mat sub = img.submat(rect);
        Mat mat = new Mat();
        Size size = new Size(300, 300);
        Imgproc.resize(sub, mat, size);
        Imgcodecs.imwrite(outFile, mat);
    }

    public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        openVideo();
//        myCvtColor("E:\\图片\\表情\\压缩前\\冯伟强.jpg");
    }


    @Override
    public void paint(Graphics g){
        if(mImg!=null){
            g.drawImage(mImg, 0, 0, mImg.getWidth(),mImg.getHeight(),this);
        }
    }
}
