package com.cc.aasignment.studentfee.web.rest;

import com.cc.aasignment.studentfee.dto.FeeDTO;
import com.cc.aasignment.studentfee.dto.StudentFeeDTO;
import com.cc.aasignment.studentfee.entity.Fee;
import com.cc.aasignment.studentfee.services.FeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fees")
public class FeeController {

    @Autowired
    private FeeService feeService;

   /* // Create Fee
    @PostMapping
    public ResponseEntity<Fee> createFee(@RequestBody FeeDTO feeRequestDTO) {
        Fee fee = feeService.createFee(feeRequestDTO);
        return ResponseEntity.status(201).body(fee);
    }*/

    // Get Fee by student ID
    @GetMapping("/{studentId}")
    public ResponseEntity<StudentFeeDTO> getFee(@PathVariable Long studentId, @RequestHeader("Authorization") String authorizationHeader) {
        StudentFeeDTO fee = feeService.getFeeByStudentId(studentId, authorizationHeader);
        return ResponseEntity.ok(fee);
    }

    // Delete Fee by student ID
    @DeleteMapping("/{studentId}")
    public ResponseEntity<String> deleteFee(@PathVariable Long studentId) {
        feeService.deleteFeeByStudentId(studentId);
        return ResponseEntity.ok("Fee record deleted successfully");
    }
}
