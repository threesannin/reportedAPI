package com.cst495.reportedAPI.entities;

public class Response {
    private String status;
    private Boolean error;

    public Response(String status, Boolean error) {
        this.status = status;
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "Response{" +
                "status='" + status + '\'' +
                ", error=" + error +
                '}';
    }
}
