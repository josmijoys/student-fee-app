package com.cc.aasignment.studentfee.services;


import com.cc.aasignment.studentfee.dto.StudentDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpEntity;

import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private RestTemplate restTemplate;

    // Method to fetch student details by studentId from the third-party API
    public List<StudentDetail> getStudentDetailsById(Long studentId, String authorizationHeader) {
        // Define the third-party API endpoint with studentId
        String url = "https://us-central1-schoolstudentbasicdetails.cloudfunctions.net/api/student/get-student-detail-by-id/" + studentId;

        // Set up headers
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer "+authorizationHeader);
        headers.set("api-key", "test");

        // Create the request entity with headers
        HttpEntity<String> entity = new HttpEntity<>(headers);

        // Call the third-party API and directly deserialize into a List<StudentDetail>
        ResponseEntity<List<StudentDetail>> response = restTemplate.exchange(
            url, HttpMethod.GET, entity,
            (Class<List<StudentDetail>>) (Object) List.class
        );

        // Check if the response is valid and extract the student details
        if (response != null && response.getBody() != null && !response.getBody().isEmpty()) {
            return response.getBody(); // Return the list of students
        } else {
            throw new RuntimeException("Student not found or error occurred.");
        }
    }
}
