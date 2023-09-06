package com.example.tikatest.utils;

/**
 * @author 张峰
 * @create 2022/2/21 20:37
 */
public class ApiResponse {
    /**
     * 状态码
     */
    private Integer code;
    /**
     * 数据
     */
    private Object data;
    /**
     * 状态信息
     */
    private String msg;
    public ApiResponse(){}
    public ApiResponse(Integer code, Object data, String msg){
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    /**
     * 成功
     */
    public static ApiResponse success(){
        return new ApiResponse(0,null,null);
    }

    /**
     * 成功
     * @param data 数据
     */
    public static ApiResponse success(Object data){
        return new ApiResponse(0,data,null);
    }

    /**
     * 成功
     * @param data 数据
     * @param msg 状态信息
     */
    public static ApiResponse success(Object data, String msg){
        return new ApiResponse(0,data,msg);
    }

    /**
     * 失败
     * @param msg 数据
     */
    public static ApiResponse error(String msg){
        return new ApiResponse(-1,null,msg);
    }

    /**
     * 失败
     * @param code 状态码
     * @param msg 数据
     */
    public static ApiResponse error(Integer code, String msg){
        return new ApiResponse(code,null,msg);
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
}
