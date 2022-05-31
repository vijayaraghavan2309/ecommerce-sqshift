package com.ecommerce.pojo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonResponse {
    private boolean status;
    private String message;

    public CommonResponse(boolean status, String message) {
        this.status = status;
        this.message = message;
    }

    public static CommonResponse success(String message) {
        return new CommonResponse(true, message);
    }

    public static CommonResponse failed(String message) {
        return new CommonResponse(false, message);
    }

}
