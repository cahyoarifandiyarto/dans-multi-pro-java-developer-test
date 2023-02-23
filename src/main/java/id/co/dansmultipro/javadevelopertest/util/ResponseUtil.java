package id.co.dansmultipro.javadevelopertest.util;

import id.co.dansmultipro.javadevelopertest.model.response.APIResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public class ResponseUtil {

    public static <T> ResponseEntity<APIResponse<T>> buildResponse(HttpStatus httpStatus, T data, Map<String, List<String>> errors) {
        APIResponse<T> apiResponse = APIResponse.<T>builder()
                .code(httpStatus.value())
                .status(httpStatus.name())
                .errors(errors)
                .data(data)
                .build();

        return ResponseEntity.status(httpStatus).body(apiResponse);
    }

}
