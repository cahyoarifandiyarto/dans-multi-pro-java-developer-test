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
public class GetJobDetailResponse implements Serializable {

    private static final long serialVersionUID = 2365943169755581153L;

    private String id;

    private String type;

    private String url;

    private String createdAt;

    private String company;

    private String companyUrl;

    private String location;

    private String title;

    private String description;

    private String howToApply;

    private String companyLogo;

}
