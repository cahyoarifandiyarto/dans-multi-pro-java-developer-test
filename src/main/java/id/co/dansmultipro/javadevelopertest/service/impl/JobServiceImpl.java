package id.co.dansmultipro.javadevelopertest.service.impl;

import id.co.dansmultipro.javadevelopertest.model.response.GetJobDetailDansMultiProResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobDetailResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobListDansMultiProResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobListResponse;
import id.co.dansmultipro.javadevelopertest.service.DansMultiProService;
import id.co.dansmultipro.javadevelopertest.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class JobServiceImpl implements JobService {

    private final DansMultiProService dansMultiProService;

    @Override
    public List<GetJobListResponse> getJobList() {
        List<GetJobListDansMultiProResponse> getJobListDansMultiProResponses = dansMultiProService.getJobList();

        return getJobListDansMultiProResponses.stream()
                .map(getJobListDansMultiProResponse -> GetJobListResponse.builder()
                        .id(getJobListDansMultiProResponse.getId())
                        .type(getJobListDansMultiProResponse.getType())
                        .url(getJobListDansMultiProResponse.getUrl())
                        .createdAt(getJobListDansMultiProResponse.getCreatedAt())
                        .company(getJobListDansMultiProResponse.getCompany())
                        .companyUrl(getJobListDansMultiProResponse.getCompanyUrl())
                        .location(getJobListDansMultiProResponse.getLocation())
                        .title(getJobListDansMultiProResponse.getTitle())
                        .description(getJobListDansMultiProResponse.getDescription())
                        .howToApply(getJobListDansMultiProResponse.getHowToApply())
                        .companyLogo(getJobListDansMultiProResponse.getCompanyLogo())
                        .build())
                .collect(Collectors.toList());
    }

    @Override
    public GetJobDetailResponse getJobDetail(String id) {
        GetJobDetailDansMultiProResponse getJobDetailDansMultiProResponse = dansMultiProService.getJobDetail(id);

        return GetJobDetailResponse.builder()
                .id(getJobDetailDansMultiProResponse.getId())
                .type(getJobDetailDansMultiProResponse.getType())
                .url(getJobDetailDansMultiProResponse.getUrl())
                .createdAt(getJobDetailDansMultiProResponse.getCreatedAt())
                .company(getJobDetailDansMultiProResponse.getCompany())
                .companyUrl(getJobDetailDansMultiProResponse.getCompanyUrl())
                .location(getJobDetailDansMultiProResponse.getLocation())
                .title(getJobDetailDansMultiProResponse.getTitle())
                .description(getJobDetailDansMultiProResponse.getDescription())
                .howToApply(getJobDetailDansMultiProResponse.getHowToApply())
                .companyLogo(getJobDetailDansMultiProResponse.getCompanyLogo())
                .build();
    }
}
