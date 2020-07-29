package com.pengesoft.crmsystem.component;

import pengesoft.account.LoginResult;

import java.io.Serializable;

/**
 * 通用Http响应模板
 *
 * @author Anluming
 * @date 2019/9/9 18:53
 */
public class Result<T> implements Serializable {

    public static Result success() {
        return new Result(true, 200, "success");
    }

    public static <T> Result<T> success(T data) {
        return new Result<>(true, 200, "success", data);
    }



    public static Result fail2(String message) {

        return new Result(false, 500, message);
    }
//    public static Result fail(ResponseStatus response) {
//        return new Result(response.value(), response.reason());
//    }

    public static Result internalError(String reason) {
        return new Result(500, reason);
    }

    public static Result fail(String data) {
        return new Result(
                true, 200, "success",data);
    }




    public Result() {

    }




    public Result(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Result(Boolean success, int code, LoginResult result, T data) {
        this.success = success;
        this.code = code;
        Result = result;
        this.data = data;
    }

    public Result(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public Result(Boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    public Result(Boolean success, int code, String message, T data) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Result(Boolean success, int code, String message, String error) {
        this.success = success;
        this.code = code;
        this.message = message;
        this.error = error;
    }

    /**
     *
     */
    private static final long serialVersionUID = -2402122704294916086L;

    private Boolean success = Boolean.TRUE;
    private int code;
    private String message;
    private String error;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public LoginResult getResult() {
        return Result;
    }

    public void setResult(LoginResult result) {
        Result = result;
    }

    private LoginResult Result;

    private T data;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }



    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
