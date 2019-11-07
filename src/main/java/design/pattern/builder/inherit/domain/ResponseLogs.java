package design.pattern.builder.inherit.domain;

import lombok.Data;

/**
 * @Author ZhangGJ
 * @Date 2019/11/04
 */
@Data
public class ResponseLogs{

    private long responseLogId;
    /**
     * log-token
     */
    private long logToken;
    /**
     * 响应时间
     */
    private String responseTime;
    /**
     * 响应码
     */
    private int responseStatus;
    /**
     * 响应信息
     */
    private String responseInfo;
    /**
     * 响应JSON
     */
    private String responseJson;
    /**
     * 响应JSON所占字节数
     */
    private String responseJsonByte;
    /**
     * 请求响应时间差(毫秒)
     */
    private long timeDifferent;

    private ResponseLogs(Builder builder) {
        this.responseLogId = builder.responseLogId;
        this.logToken = builder.logToken;
        this.responseTime = builder.responseTime;
        this.responseStatus = builder.responseStatus;
        this.responseInfo = builder.responseInfo;
        this.responseJson = builder.responseJson;
        this.responseJsonByte = builder.responseJsonByte;
        this.timeDifferent = builder.timeDifferent;
    }

    public static class Builder {

        private long responseLogId;
        /**
         * 响应时间
         */
        private String responseTime;
        /**
         * 响应码
         */
        private int responseStatus;
        /**
         * 响应信息
         */
        private String responseInfo;
        /**
         * 响应JSON
         */
        private String responseJson;
        /**
         * 响应JSON所占字节数
         */
        private String responseJsonByte;
        /**
         * 请求响应时间差(毫秒)
         */
        private long timeDifferent;
        /**
         * log-token
         */
        private long logToken;

        public Builder responseLogId(long responseLogId){
            this.responseLogId = responseLogId;
            return this;
        }

        public Builder logToken(long logToken){
            this.logToken = logToken;
            return this;
        }

        public Builder responseTime(String responseTime) {
            this.responseTime = responseTime;
            return this;
        }

        public Builder responseStatus(int responseStatus) {
            this.responseStatus = responseStatus;
            return this;
        }

        public Builder responseInfo(String responseInfo) {
            this.responseInfo = responseInfo;
            return this;
        }

        public Builder responseJson(String responseJson) {
            this.responseJson = responseJson;
            return this;
        }

        public Builder responseJsonByte(String responseJsonByte) {
            this.responseJsonByte = responseJsonByte;
            return this;
        }

        public Builder timeDifferent(long timeDifferent) {
            this.timeDifferent = timeDifferent;
            return this;
        }

        public ResponseLogs build() {
            return new ResponseLogs(this);
        }

    }
}
