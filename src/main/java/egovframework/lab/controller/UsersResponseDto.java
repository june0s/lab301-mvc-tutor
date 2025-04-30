package egovframework.lab.controller;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class UsersResponseDto {

    @ApiModelProperty(example = "상태코드")
    private int status;

    @ApiModelProperty(example = "메시지")
    private String message;

    @ApiModelProperty(example = "응답데이터")
    private Map<String, Object> data;

    @ApiModelProperty(example = "시간")
    private LocalDateTime timestamp;

    public UsersResponseDto() {
        this(HttpStatus.OK);
    }

    public UsersResponseDto(HttpStatus httpStatus) {
        this.status = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
        this.data = new HashMap<>();
        this.timestamp = LocalDateTime.now();
    }

    public void add(String key, Object value) {
        this.data.put(key, value);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
