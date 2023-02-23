package id.co.dansmultipro.javadevelopertest.controller;

import id.co.dansmultipro.javadevelopertest.model.response.APIResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobDetailResponse;
import id.co.dansmultipro.javadevelopertest.model.response.GetJobListResponse;
import id.co.dansmultipro.javadevelopertest.service.JobService;
import id.co.dansmultipro.javadevelopertest.util.ResponseUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/api/jobs", consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @GetMapping
    public ResponseEntity<APIResponse<List<GetJobListResponse>>> getJobList() {
        return ResponseUtil.buildResponse(HttpStatus.OK, jobService.getJobList(), null);
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<GetJobDetailResponse>> getJobDetail(@PathVariable String id) {
        return ResponseUtil.buildResponse(HttpStatus.OK, jobService.getJobDetail(id), null);
    }

}
