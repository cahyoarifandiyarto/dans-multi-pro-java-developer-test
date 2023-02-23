package id.co.dansmultipro.javadevelopertest.service;

import id.co.dansmultipro.javadevelopertest.model.request.LoginRequest;
import id.co.dansmultipro.javadevelopertest.model.response.LoginResponse;

public interface LoginService {

    LoginResponse login(LoginRequest request);

}
