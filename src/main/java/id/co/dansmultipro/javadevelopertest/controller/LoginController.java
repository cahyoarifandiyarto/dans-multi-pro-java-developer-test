package id.co.dansmultipro.javadevelopertest.controller;

import id.co.dansmultipro.javadevelopertest.model.request.LoginRequest;
import id.co.dansmultipro.javadevelopertest.model.response.APIResponse;
import id.co.dansmultipro.javadevelopertest.model.response.LoginResponse;
import id.co.dansmultipro.javadevelopertest.service.LoginService;
import id.co.dansmultipro.javadevelopertest.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/api/login", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @PostMapping
    public ResponseEntity<APIResponse<LoginResponse>> login(@RequestBody LoginRequest request) {
        return ResponseUtil.buildResponse(HttpStatus.OK, loginService.login(request), null);
    }

}
