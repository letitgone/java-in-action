package design.pattern.builder.inherit.domain;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2019/11/04
 */
@Data
public class RequestLogs{

    private long requestLogId;
    /**
     * 请求时间
     */
    private String requestTime;
    /**
     * 请求JSON
     */
    private String requestJson;
    /**
     * 请求JSON所占字节数
     */
    private String requestJsonByte;
    /**
     * 请求方式
     */
    private String requestWay;
    /**
     * 操作平台
     */
    private String requestPlatform;
    /**
     * 请求URL
     */
    private String requestUrl;
    /**
     * 操作人
     */
    private String requestOperator;

    private RequestLogs(Builder builder){
        this.requestLogId = builder.requestLogId;
        this.requestTime = builder.requestTime;
        this.requestJson = builder.requestJson;
        this.requestJsonByte = builder.requestJsonByte;
        this.requestWay = builder.requestWay;
        this.requestPlatform = builder.requestPlatform;
        this.requestUrl = builder.requestUrl;
        this.requestOperator = builder.requestOperator;
    }

    public static class Builder{

        private long requestLogId;
        /**
         * 请求时间
         */
        private String requestTime;
        /**
         * 请求JSON
         */
        private String requestJson;
        /**
         * JSON所占字节数
         */
        private String requestJsonByte;
        /**
         * 请求方式
         */
        private String requestWay;
        /**
         * 操作平台
         */
        private String requestPlatform;
        /**
         * 请求URL
         */
        private String requestUrl;
        /**
         * 操作人
         */
        private String requestOperator;

        public Builder requestLogId(long requestLogId){
            this.requestLogId = requestLogId;
            return this;
        }

        public Builder requestTime(String requestTime){
            this.requestTime = requestTime;
            return this;
        }

        public Builder requestJson(String requestJson){
            this.requestJson = requestJson;
            return this;
        }

        public Builder requestJsonByte(String requestJsonByte){
            this.requestJsonByte = requestJsonByte;
            return this;
        }

        public Builder requestWay(String requestWay){
            this.requestWay = requestWay;
            return this;
        }
        public Builder requestPlatform(String requestPlatform){
            this.requestPlatform = requestPlatform;
            return this;
        }
        public Builder requestUrl(String requestUrl){
            this.requestUrl = requestUrl;
            return this;
        }
        public Builder requestOperator(String requestOperator){
            this.requestOperator = requestOperator;
            return this;
        }

        public RequestLogs build(){
            return new RequestLogs(this);
        }

    }
}
