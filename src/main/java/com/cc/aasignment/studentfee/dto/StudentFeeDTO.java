package com.cc.aasignment.studentfee.dto;

import com.cc.aasignment.studentfee.entity.Fee;

import java.util.List;

public class StudentFeeDTO {
    private List<StudentDetail> studentDetail;
    private FeeDTO fee;

    public List<StudentDetail> getStudentDetail() {
        return studentDetail;
    }

    public void setStudentDetail(List<StudentDetail> studentDetail) {
        this.studentDetail = studentDetail;
    }

    public FeeDTO getFee() {
        return fee;
    }

    public void setFee(FeeDTO fee) {
        this.fee = fee;
    }
}
