package com.dt.ds.service;

import com.dt.ds.dto.DepartmentDto;
import com.dt.ds.dto.ResponseDto;
import com.dt.ds.exception.GeneralException;
import org.springframework.stereotype.Service;

@Service
public interface DepartmentService {
    ResponseDto save(DepartmentDto departmentDto) throws GeneralException;

    ResponseDto findDepartmentById(Long departmentId) throws GeneralException;
}
