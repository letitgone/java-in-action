package design.pattern.builder.inherit.domain;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2019/11/04
 */
@Data
public class ExceptionLogs{

    private long exceptionLogId;
    /**
     * log-token
     */
    private long logToken;
    /**
     * 异常时间
     */
    private String exceptionTime;
    /**
     * 异常信息
     */
    private String exceptionInfo;
    /**
     * 栈轨迹
     */
    private String stackTrack;

    private ExceptionLogs(Builder builder){
        this.exceptionLogId = builder.exceptionLogId;
        this.exceptionTime = builder.exceptionTime;
        this.logToken = builder.logToken;
        this.exceptionInfo = builder.exceptionInfo;
        this.stackTrack = builder.stackTrack;
    }

    public static class Builder{
        private long exceptionLogId;
        /**
         * 异常时间
         */
        private String exceptionTime;
        /**
         * 异常信息
         */
        private String exceptionInfo;
        /**
         * 栈轨迹
         */
        private String stackTrack;
        /**
         * log-token
         */
        private long logToken;

        public Builder exceptionLogId(long exceptionLogId){
            this.exceptionLogId = exceptionLogId;
            return this;
        }

        public Builder exceptionTime(String exceptionTime){
            this.exceptionTime = exceptionTime;
            return this;
        }

        public Builder LogToken(long logToken){
            this.logToken = logToken;
            return this;
        }

        public Builder exceptionInfo(String exceptionInfo){
            this.exceptionInfo = exceptionInfo;
            return this;
        }
        public Builder stackTrack(String stackTrack){
            this.stackTrack = stackTrack;
            return this;
        }

        public ExceptionLogs build(){
            return new ExceptionLogs(this);
        }

    }
}
