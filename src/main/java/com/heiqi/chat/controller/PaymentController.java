package com.heiqi.chat.controller;

import com.alibaba.fastjson.JSONObject;
import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradeAppPayRequest;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.response.AlipayTradeAppPayResponse;
import com.alipay.api.response.AlipayTradePagePayResponse;
import com.heiqi.chat.common.PaymentConstants;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.PrintWriter;

@RestController
@RequestMapping("/api/pay")
public class PaymentController {
    //app端的支付
    @GetMapping("/appPay")
    public String appPay() throws AlipayApiException {
        AlipayClient alipayClient = new DefaultAlipayClient(PaymentConstants.URL,
                PaymentConstants.APPID,
                PaymentConstants.PRIVATE_KEY,
                PaymentConstants.FORMAT,
                PaymentConstants.CHARSET,
                PaymentConstants.ALIPAY_PUBLIC_KEY,
                PaymentConstants.SIGN_TYPE);
        AlipayTradeAppPayRequest request = new AlipayTradeAppPayRequest();
//异步接收地址，仅支持http/https，公网可访问
        request.setNotifyUrl(PaymentConstants.NOTIFY_URL);
//同步跳转地址，仅支持http/https
        request.setReturnUrl(PaymentConstants.RETURN_URL);
/******必传参数******/
        JSONObject bizContent = new JSONObject();
//商户订单号，商家自定义，保持唯一性
        bizContent.put("out_trade_no", System.currentTimeMillis()+"");
//支付金额，最小值0.01元
        bizContent.put("total_amount", 0.01);
//订单标题，不可使用特殊符号
        bizContent.put("subject", "测试商品");
//电脑网站支付场景固定传值FAST_INSTANT_TRADE_PAY
//        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

/******可选参数******/
//bizContent.put("time_expire", "2022-08-01 22:00:00");

//// 商品明细信息，按需传入
//JSONArray goodsDetail = new JSONArray();
//JSONObject goods1 = new JSONObject();
//goods1.put("goods_id", "goodsNo1");
//goods1.put("goods_name", "子商品1");
//goods1.put("quantity", 1);
//goods1.put("price", 0.01);
//goodsDetail.add(goods1);
//bizContent.put("goods_detail", goodsDetail);

//// 扩展信息，按需传入
//JSONObject extendParams = new JSONObject();
//extendParams.put("sys_service_provider_id", "2088511833207846");
//bizContent.put("extend_params", extendParams);

        request.setBizContent(bizContent.toString());
        AlipayTradeAppPayResponse response = alipayClient.sdkExecute(request);
        if(response.isSuccess()){
            System.out.println("调用成功");
            return response.getBody();
        } else {
            System.out.println("调用失败");
            return "失败" ;
        }
    }

    //网页端的支付
    @GetMapping("/webPay")
    public void webPay(HttpServletResponse servletResponse) throws AlipayApiException, IOException {
        AlipayClient alipayClient = new DefaultAlipayClient(PaymentConstants.URL,
                PaymentConstants.APPID,
                PaymentConstants.PRIVATE_KEY,
                PaymentConstants.FORMAT,
                PaymentConstants.CHARSET,
                PaymentConstants.ALIPAY_PUBLIC_KEY,
                PaymentConstants.SIGN_TYPE);
        AlipayTradePagePayRequest request = new AlipayTradePagePayRequest();
//异步接收地址，仅支持http/https，公网可访问
        request.setNotifyUrl(PaymentConstants.NOTIFY_URL);
//同步跳转地址，仅支持http/https
        request.setReturnUrl(PaymentConstants.RETURN_URL);
/******必传参数******/
        JSONObject bizContent = new JSONObject();
//商户订单号，商家自定义，保持唯一性
        bizContent.put("out_trade_no", System.currentTimeMillis()+"");
//支付金额，最小值0.01元
        bizContent.put("total_amount", 0.01);
//订单标题，不可使用特殊符号
        bizContent.put("subject", "测试商品");
//电脑网站支付场景固定传值FAST_INSTANT_TRADE_PAY
        bizContent.put("product_code", "FAST_INSTANT_TRADE_PAY");

/******可选参数******/
//bizContent.put("time_expire", "2022-08-01 22:00:00");

//// 商品明细信息，按需传入
//JSONArray goodsDetail = new JSONArray();
//JSONObject goods1 = new JSONObject();
//goods1.put("goods_id", "goodsNo1");
//goods1.put("goods_name", "子商品1");
//goods1.put("quantity", 1);
//goods1.put("price", 0.01);
//goodsDetail.add(goods1);
//bizContent.put("goods_detail", goodsDetail);

//// 扩展信息，按需传入
//JSONObject extendParams = new JSONObject();
//extendParams.put("sys_service_provider_id", "2088511833207846");
//bizContent.put("extend_params", extendParams);

        request.setBizContent(bizContent.toString());
        AlipayTradePagePayResponse response = alipayClient.pageExecute(request);
        if(response.isSuccess()){
            servletResponse.setContentType("text/html;charset=utf-8");
            PrintWriter writer = servletResponse.getWriter();
            writer.write("<!DOCTYPE html>\n" +
                    "<html lang=\"en\">\n" +
                    "<head>\n" +
                    "    <meta charset=\"UTF-8\">\n" +
                    "    <title>Title</title>\n" +
                    "</head>\n" +
                    "<body>");
            writer.write(response.getBody());
            writer.write("</body>\n" +
                    "</html>");
            writer.flush();
            writer.close();
            System.out.println("调用成功");

        } else {
            System.out.println("调用失败");

        }
    }

}
