package id.co.dansmultipro.javadevelopertest.service.impl;

import id.co.dansmultipro.javadevelopertest.entity.User;
import id.co.dansmultipro.javadevelopertest.exception.NotFoundException;
import id.co.dansmultipro.javadevelopertest.exception.UnauthorizedException;
import id.co.dansmultipro.javadevelopertest.model.request.LoginRequest;
import id.co.dansmultipro.javadevelopertest.model.response.LoginResponse;
import id.co.dansmultipro.javadevelopertest.repository.UserRepository;
import id.co.dansmultipro.javadevelopertest.service.LoginService;
import id.co.dansmultipro.javadevelopertest.util.JWTUtil;
import id.co.dansmultipro.javadevelopertest.validation.Validation;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    private final Validation validation;

    private final UserRepository userRepository;

    @Override
    public LoginResponse login(LoginRequest request) {
        validation.validate(request);

        Map<String, List<String>> errors = new HashMap<>();

        User user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> {
                    errors.put("message", List.of("Username not found"));

                    throw new NotFoundException(errors);
                });

        if (!request.getPassword().equals(user.getPassword())) {
            errors.put("message", List.of("Wrong password"));

            throw new UnauthorizedException(errors);
        }

        return LoginResponse.builder()
                .accessToken(JWTUtil.generateAccessToken(user))
                .build();
    }

}
