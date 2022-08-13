package com.wang.nginxstudy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;

/**
 * @version 1.0
 * @Aythor lucksoul 王吉慧
 * @date 2021/10/24 19:05
 * @description
 */
@Controller
@RequestMapping("nginx")
public class controller {

    @RequestMapping("/ngnixHeaderTest")
    @ResponseBody
    public String ngnixHeaderTest (HttpServletRequest request, HttpServletResponse response){
        System.out.println(request);
        return "success";
    }


    @RequestMapping("/ngnixXForwardedForTest")
    @ResponseBody
    public String ngnixXForwardedForTest (HttpServletRequest request, HttpServletResponse response){
        StringBuffer buffer = new StringBuffer();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String s = headerNames.nextElement();
            buffer.append(s +":" + request.getHeader(s) +"<br>");
        }
        String remoteHost = request.getRemoteHost();
        int remotePort = request.getRemotePort();
        String remoteAddr = request.getRemoteAddr();
        String remoteUser = request.getRemoteUser();

        buffer.append("remoteHost="+remoteHost);
        buffer.append("remotePort="+remotePort);
        buffer.append("remoteAddr="+remoteAddr);
        buffer.append("remoteUser="+remoteUser);

        String ipaddress = request.getHeader("x-forwarded-for");
        buffer.append("<br>ipaddress="+ipaddress);

        System.out.println(buffer.toString());
        return buffer.toString();
    }


}
