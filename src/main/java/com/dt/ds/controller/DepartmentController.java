package com.dt.ds.controller;

import com.dt.ds.dto.DepartmentDto;
import com.dt.ds.dto.ResponseDto;
import com.dt.ds.exception.GeneralException;
import com.dt.ds.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;


    @PostMapping("/save")
    public ResponseEntity<ResponseDto> saveDepartment(@RequestBody DepartmentDto departmentDto) throws GeneralException {
        log.info("Inside saveDepartment method of DepartmentController.");
        ResponseDto save = departmentService.save(departmentDto);
        return new ResponseEntity<ResponseDto>(save, HttpStatus.OK);
    }

    @PostMapping("findByDepartmentById/{id}")
    public ResponseEntity<ResponseDto> findDepartmentById(@PathVariable("id") Long departmentId) throws GeneralException {
        log.info("Inside findDepartmentById method of DepartmentController.");
        ResponseDto getAllInfo = departmentService.findDepartmentById(departmentId);
        return new ResponseEntity<ResponseDto>(getAllInfo, HttpStatus.OK);
    }

}
