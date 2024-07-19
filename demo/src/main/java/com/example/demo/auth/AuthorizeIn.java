package com.example.demo.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AuthorizeIn {
    @NotBlank(message="缺少response_type參數")
    private String responseType;

    @NotBlank(message="缺少client_id參數")
    private String clientId;

    private String state;

    @NotBlank(message="缺少redirect_url參數")
    private String redirectUrl;

}
