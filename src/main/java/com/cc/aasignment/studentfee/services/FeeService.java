package com.cc.aasignment.studentfee.services;


import com.cc.aasignment.studentfee.dto.FeeDTO;
import com.cc.aasignment.studentfee.dto.StudentDetail;
import com.cc.aasignment.studentfee.dto.StudentFeeDTO;
import com.cc.aasignment.studentfee.entity.Fee;
import com.cc.aasignment.studentfee.repository.FeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FeeService {

    @Autowired
    private FeeRepository feeRepository;

    @Autowired
    StudentService studentService;

    // Get fee by student ID
    public StudentFeeDTO getFeeByStudentId(Long studentId, String authorizationHeader) {

        StudentFeeDTO studentFeeDTO = new StudentFeeDTO();

        List<StudentDetail> studentDetail = studentService.getStudentDetailsById(studentId, authorizationHeader);

        studentFeeDTO.setStudentDetail(studentDetail);

        FeeDTO feeDTO = new FeeDTO();

        Fee fee = feeRepository.findByStudentId(studentId)
            .orElseThrow(() -> new RuntimeException("Fee record not found"));

        feeDTO.setFeeAmount(fee.getFeeAmount());
        feeDTO.setFeeStatus(fee.getFeeStatus());

        studentFeeDTO.setFee(feeDTO);

        return studentFeeDTO;
    }

    // Delete fee by student ID
    public void deleteFeeByStudentId(Long studentId) {
        Fee fee = feeRepository.findByStudentId(studentId)
            .orElseThrow(() -> new RuntimeException("Fee record not found"));
        feeRepository.delete(fee);
    }
}
