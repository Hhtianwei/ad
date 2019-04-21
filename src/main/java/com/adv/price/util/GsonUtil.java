package com.adv.price.util;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@Slf4j
public class GsonUtil {
	
	/**将对象转换为json格式并输出*/
	public static void writeJson(Object obj, HttpServletResponse response){
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = null;
		try{
			out = response.getWriter();
			out.println(obj);
		}catch(IOException e){
			log.error("IO异常,{}",e);
		}finally{
			out.flush();
			out.close();
		}
	}
	
	/**403异常响应信息*/
	public final static void writeErrorMsg(String msg, HttpServletResponse response){
		try{
			response.setContentType("text/plain;charset=UTF-8");
			log.debug("ajax 请求 校验错误");
			response.getWriter().write(msg);
        }catch(IOException e){
			log.error("返回错误信息异常,{}",e);
		}
	}
}
