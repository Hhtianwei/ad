package com.adv.price.util;


import com.adv.price.dto.Result;

public class ResultUtil {

    public static Result success(){
        return success(null);
    }

    public  static <T> Result<T> success(T data){
        Result result = new Result();
        result.setCode(6666);
        result.setSuccess(true);
        result.setData(data);
        return result;
    }

    public  static <T> Result<T> error(int code,String msg){
        Result result = new Result();
        result.setCode(code);
        result.setErrorMsg(msg);
        return result;
    }


}
