package id.co.dansmultipro.javadevelopertest.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import id.co.dansmultipro.javadevelopertest.model.response.APIResponse;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import javax.crypto.SecretKey;
import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebFilter(urlPatterns = "/v1/api/jobs/*")
@RequiredArgsConstructor
public class JWTFilter implements Filter {

    private final ObjectMapper objectMapper;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        Map<String, List<String>> errors = new HashMap<>();

        String authorization = httpServletRequest.getHeader("Authorization");

        APIResponse<Object> apiResponse = APIResponse.builder()
                .code(HttpStatus.UNAUTHORIZED.value())
                .status(HttpStatus.UNAUTHORIZED.name())
                .build();

        if (authorization == null) {
            errors.put("message", List.of("Authorization cannot be null"));

            apiResponse.setErrors(errors);

            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

            objectMapper.writeValue(httpServletResponse.getWriter(), apiResponse);
        } else if (!authorization.startsWith("Bearer ")) {
            errors.put("message", List.of("Authorization must be start with Bearer"));

            apiResponse.setErrors(errors);

            httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
            httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

            objectMapper.writeValue(httpServletResponse.getWriter(), apiResponse);
        } else {
            String accessToken = authorization.split(" ")[1];
            SecretKey secretKey = Keys.hmacShaKeyFor("secret".getBytes(StandardCharsets.UTF_8));

            try {
                Jwts.parserBuilder()
                        .setSigningKey(secretKey)
                        .build()
                        .parseClaimsJws(accessToken);

                filterChain.doFilter(servletRequest, servletResponse);
            } catch (JwtException ex) {
                errors.put("message", List.of(ex.getMessage()));

                apiResponse.setErrors(errors);

                httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
                httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);

                objectMapper.writeValue(httpServletResponse.getWriter(), apiResponse);
            }
        }
    }

}
