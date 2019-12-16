package com.demo.threadsym;

import com.alibaba.fastjson.JSONObject;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


@Slf4j
public class Concurrent2 {
    final static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static void main(String[] args) throws Exception {

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2000, 5000, 2, TimeUnit.MINUTES,
                new ArrayBlockingQueue<Runnable>(5000));
        //模拟100人并发请求
        CountDownLatch latch = new CountDownLatch(1);
        //模拟100个用户
        for (int i = 0; i < 100; i++) {

            AnalogUser analogUser = new AnalogUser(latch);
            executor.execute(analogUser);

        }
        //计数器減一  所有线程释放 并发访问。
        latch.countDown();

    }


    static class AnalogUser implements Runnable {
        CountDownLatch latch;


        public AnalogUser(CountDownLatch latch) {
            this.latch = latch;

        }


        @Override
        public void run() {
            long starTime = 0;
            try {
                starTime = System.currentTimeMillis();
                latch.await();
                System.out.println("请求开始了");
                JSONObject jsonObject = httpPost("http://192.168.100.43:8080/lua/requestIdfa",
                        "userId=3&bundleName=xxxxxx&country=US&thirdParty=sdfsfs");
                System.out.println("返回的状态码为："+jsonObject.get("code"));
                System.out.println("返回的状态信息："+jsonObject.get("desc"));
                System.out.println("返回的内容为："+jsonObject.get("content"));

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            long endTime = System.currentTimeMillis();
            Long t = endTime - starTime;
            System.out.println(t / 1000F + "秒");
        }


    }

    static JSONObject httpPost(String url, String strParam) {

        // post请求返回结果
        CloseableHttpClient httpClient = HttpClients.createDefault();
        JSONObject jsonResult = null;
        HttpPost httpPost = new HttpPost(url);
        // 设置请求和传输超时时间
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(2000).setConnectTimeout(2000).build();
        httpPost.setConfig(requestConfig);
        try {
            if (null != strParam) {
                // 解决中文乱码问题
                StringEntity entity = new StringEntity(strParam, "utf-8");
                entity.setContentEncoding("UTF-8");
                entity.setContentType("application/x-www-form-urlencoded");
                httpPost.setEntity(entity);
            }
            CloseableHttpResponse result = httpClient.execute(httpPost);
            //请求发送成功，并得到响应
            if (result.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
                String str;
                try {
                    //读取服务器返回过来的json字符串数据
                    str = EntityUtils.toString(result.getEntity(), "utf-8");
                    //把json字符串转换成json对象
                    jsonResult = JSONObject.parseObject(str);
                } catch (Exception e) {

                }
            }
        } catch (IOException e) {

        } finally {
            httpPost.releaseConnection();
        }
        return jsonResult;
    }

}