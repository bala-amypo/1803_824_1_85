// package com.example.demo.dto;
// import lombok.AllArgsConstructor;
// import lombok.Data;
// @Data @AllArgsConstructor
// public class ApiResponse { private boolean success; private String message; private Object data; }



package com.example.demo.dto;

public class ApiResponse {
    private boolean success;
    private String message;
    private Object data;

    // Default Constructor
    public ApiResponse() {
    }

    // Constructor with all fields
    public ApiResponse(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    // Constructor without data (useful for simple success/error messages)
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    // Manual Getters and Setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
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
