package com.luziye.bootluanch.exception;


public class AjaxResponse {


    private boolean isok;   //请求是否处理成功
    private int code;          //请求响应状态码（200、400、500）
    private String message;  //请求结果描述信息
    private Object data;  //请求结果数据

    private AjaxResponse() {

    }
    public static AjaxResponse error(CustomException e){
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(false);
        resultBean.setCode(e.getCode());
        if (e.getCode()== CustomExceptionType.USER_INPUT_ERROR.getCode()){
            resultBean.setMessage(e.getMessage());
        }else if (e.getCode()== CustomExceptionType.SYSTEM_ERROR.getCode()){
            resultBean.setMessage(e.getMessage() + ",系统出现异常，请联系管理员电话：13756108723进行处理!");
        }else if (e.getCode()== CustomExceptionType.PARAM_NULL.getCode()){
            resultBean.setMessage(e.getMessage() + ",请输入参数！");
        }else{
            resultBean.setMessage("系统出现未知异常，请联系管理员电话：13756108723进行处理!");
        }
        return resultBean;
    }
    //请求成功的响应，不带查询数据（用于删除、修改、新增接口）
    public static AjaxResponse success() {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        return resultBean;
    }

    //请求成功的响应，带有查询数据（用于数据查询接口）
    public static AjaxResponse success(Object data) {
        AjaxResponse resultBean = new AjaxResponse();
        resultBean.setIsok(true);
        resultBean.setCode(200);
        resultBean.setMessage("success");
        resultBean.setData(data);
        return resultBean;
    }

    public boolean isIsok() {
        return isok;
    }

    public void setIsok(boolean isok) {
        this.isok = isok;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}