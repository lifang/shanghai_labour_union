/**
 * 
 */
package com.comdosoft.union.common;

/**
 * api响应消息体
 * 
 * @author zengguang
 * 
 */
public class SysResponse {

    /**
     * 成功
     */
    public static final Integer SUCCESS = 1;

    /**
     * 业务处理失败
     */
    public static final Integer FAILURE = -1;

    /**
     * token失效
     */
    public static final Integer TOKEN_INVALID = -2;

    /**
     * 系统异常
     */
    public static final Integer EXCEPTION = -3;

    /**
     * 返回码
     */
    private Integer code = SUCCESS;

    /**
     * 返回消息
     */
    private String message;

    /**
     * token
     */
    private String token;
    private Integer total;//查询的总页数
    
    /**  
     * 获取 total  
     * @return total
     */
    public Integer getTotal() {
        return total;
    }

    /**  
     * 设置 total  
     * @param total
     */
    public void setTotal(Integer total) {
        this.total = total;
    }

    /**
     * 返回消息体
     */
    private Object result;

    /**
     * @return the code
     */
    public Integer getCode() {
        return code;
    }

    /**
     * @param code
     *            the code to set
     */
    public void setCode(Integer code) {
        this.code = code;
    }

    /**
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message
     *            the message to set
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token
     *            the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the result
     */
    public Object getResult() {
        return result;
    }

    /**
     * @param result
     *            the result to set
     */
    public void setResult(Object result) {
        this.result = result;
    }

    /**
     * @return the success
     */
    public static Integer getSuccess() {
        return SUCCESS;
    }

    /**
     * @return the failure
     */
    public static Integer getFailure() {
        return FAILURE;
    }

    /**
     * @return the exception
     */
    public static Integer getException() {
        return EXCEPTION;
    }
    
    public static SysResponse buildSuccessResponse(Object result){
    	SysResponse response = new SysResponse();
    	response.code = SUCCESS;
    	response.result = result;
    	return response;
    }

    public static SysResponse buildFailResponse(String message){
    	SysResponse response = new SysResponse();
    	response.code = FAILURE;
    	response.message = message;
    	return response;
    }
    
    public static SysResponse buildExceptionResponse(String message){
    	SysResponse response = new SysResponse();
    	response.code = EXCEPTION;
    	response.message = message;
    	return response;
    }
}