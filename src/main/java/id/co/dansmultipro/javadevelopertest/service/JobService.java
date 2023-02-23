package id.co.dansmultipro.javadevelopertest.service;

import id.co.dansmultipro.javadevelopertest.model.response.GetJobDetailResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobListResponse;

import java.util.List;

public interface JobService {

    List<GetJobListResponse> getJobList();

    GetJobDetailResponse getJobDetail(String id);

}
