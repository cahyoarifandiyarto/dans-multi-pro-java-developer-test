package id.co.dansmultipro.javadevelopertest.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class LoginRequest implements Serializable {

    private static final long serialVersionUID = -6601731314620340455L;

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
