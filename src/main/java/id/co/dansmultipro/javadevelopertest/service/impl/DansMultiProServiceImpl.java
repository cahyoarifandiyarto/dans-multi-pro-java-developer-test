package id.co.dansmultipro.javadevelopertest.service.impl;

import id.co.dansmultipro.javadevelopertest.model.response.GetJobDetailDansMultiProResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobListDansMultiProResponse;
import id.co.dansmultipro.javadevelopertest.service.DansMultiProService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class DansMultiProServiceImpl implements DansMultiProService {

    private final RestTemplate restTemplate;

    @Value("${dansMultiPro.getJobListUrl}")
    private String getJobListUrl;

    @Value("${dansMultiPro.getJobDetailUrl}")
    private String getJobDetailUrl;

    @Override
    public List<GetJobListDansMultiProResponse> getJobList() {
        ResponseEntity<GetJobListDansMultiProResponse[]> responseEntity = restTemplate.getForEntity(getJobListUrl, GetJobListDansMultiProResponse[].class);

        return Arrays.asList(Objects.requireNonNull(responseEntity.getBody()));
    }

    @Override
    public GetJobDetailDansMultiProResponse getJobDetail(String id) {
        ResponseEntity<GetJobDetailDansMultiProResponse> responseEntity = restTemplate.getForEntity(getJobDetailUrl, GetJobDetailDansMultiProResponse.class, Map.of("id", id));

        return Objects.requireNonNull(responseEntity.getBody());
    }

}
