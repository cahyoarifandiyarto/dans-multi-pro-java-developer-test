package id.co.dansmultipro.javadevelopertest.service;

import id.co.dansmultipro.javadevelopertest.model.response.GetJobDetailDansMultiProResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobListDansMultiProResponse;

import java.util.List;

public interface DansMultiProService {

    List<GetJobListDansMultiProResponse> getJobList();

    GetJobDetailDansMultiProResponse getJobDetail(String id);

}
