package com.sven.interceptorannotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@SvenInterceptor(inclusivePathPatterns = "/**", value="", exclusivePathPatterns="")
public class TestInterceptor implements HandlerInterceptor
{

    @Override
    public boolean preHandle(HttpServletRequest request,
            HttpServletResponse paramHttpServletResponse, Object paramObject)
            throws Exception
    {
        
        // TODO Auto-generated method stub
        System.out.println("call prehandle");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest paramHttpServletRequest,
            HttpServletResponse paramHttpServletResponse, Object paramObject,
            ModelAndView paramModelAndView) throws Exception
    {
        // TODO Auto-generated method stub
        System.out.println("call posthandle");
        
    }

    @Override
    public void afterCompletion(HttpServletRequest paramHttpServletRequest,
            HttpServletResponse response, Object paramObject,
            Exception paramException) throws Exception
    {
        
        response.addHeader("auto-added", "sven");
        // TODO Auto-generated method stub
        System.out.println("call afterCompletion");
    }
}
