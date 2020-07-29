package com.pengesoft.crmsystem.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import pengesoft.core.PsCoreRuntimeException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/*
 * 抛出异常统一包装
 * */
@ControllerAdvice
public class ExceptionHandleCon {

    @ExceptionHandler(PsCoreRuntimeException.class)
    @ResponseBody
    public String restError(HttpServletRequest request, HttpServletResponse response, PsCoreRuntimeException ps) {
        Map<String, Object>map = new HashMap<>();
        map.put("errMsg",ps.getMessage());
        map.put("errCode",ps.getExceptionCode());
        Map<String,Object> ret = new HashMap<>();
        ret.put("error_respone",map);
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(ret);
        return jsonArray.toJSONString();
    }
}
