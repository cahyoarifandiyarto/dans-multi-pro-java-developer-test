package id.co.dansmultipro.javadevelopertest.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginResponse implements Serializable {

    private static final long serialVersionUID = -4099334109305157239L;

    private String accessToken;

}
