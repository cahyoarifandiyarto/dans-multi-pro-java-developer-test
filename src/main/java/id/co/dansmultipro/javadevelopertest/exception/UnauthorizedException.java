package id.co.dansmultipro.javadevelopertest.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@Getter
@RequiredArgsConstructor
public class UnauthorizedException extends RuntimeException {

    private final Map<String, List<String>> errors;

}
