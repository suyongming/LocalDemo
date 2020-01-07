package com.config;

public class AlipayConfig {

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016101900725629";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAtXvtgP1tYidqJW8zaMemXlHd8HH7YqKv7P2QhqsVSn5FT7ZuGWajjX8t0kL5TvduYc6uhQKCx7TqppjygXedVmnyWRG7cw4tzGv8vPLQMGgi4jq5U+kcWAgYG8L4Gmam3pMlxBNuXeN3JE4nb2uBw9dXldw7rzsU6D5CDEAAW1RD9UEd2B1EtKcA4iKWMN81VV7/Gffmp4bQ0rbP3PAk6IqXFLZQlL/3L1iNIhoq/kLNA4UlVz5uOu6MimmQOqSImsbpHuK7AZcv61L7JN2fH6Jl/aRT0CGPBtA1klRnGtbd11p80nR4VxxUUaClxJX06bDF3Gm/0ILZDYWIReWLWQIDAQAB";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAuMCEZri8gk+TcwZzmQilQSMMQmN8/JZQAhdOqjK+vJptQJmuqX0rGCNnnqpZdTpxeFg828ah/n+aED2lzmVeqcc7VBmHC5KHzDo2kt/ahObC+fXes7QhaaeNJsITxKg4qxMEdeQBvvshBaG4wcnFjFypoAv4J+3K/lLtdBWbiRqOConoXiQ3t49fnWhPbl8s9x45/0GzwGL97sFvLDPrcPLmBzhuAFX9TZkrxAOMh0ajF64fZQbSU8RnWZA+pK1xZy5ZYnN4b9CWkLit/V7fsyMTuroUHZN7/mW+5OO/boGWFieCMV4K1ce1vjlX0HBwMs4ip6uoW26sgl3NeahJnwIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/notify_url";

    // 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    /*public static String return_url = "http://localhost/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";*/
    public static String return_url = "http://localhost:8080/alipay/callback/return_sult";
    // 签名方式，注意这里，如果步骤设置的是RSA则用RSA
    public static String sign_type = "RSA2";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";

    // 支付宝网关
    public static String log_path = "C:\\";


}