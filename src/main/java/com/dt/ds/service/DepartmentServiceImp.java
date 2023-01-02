package com.dt.ds.service;

import com.dt.ds.dto.DepartmentDto;
import com.dt.ds.dto.ResponseDto;
import com.dt.ds.entity.Department;
import com.dt.ds.exception.GeneralException;
import com.dt.ds.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public ResponseDto save(DepartmentDto departmentDto) throws GeneralException {
        try{
            log.info("Inside saveDepartment of DepartmentServiceImp");
            Department depart = new Department();
            depart.setDepartmentName(departmentDto.getDepartmentName());
            depart.setDepartmentAddress(departmentDto.getDepartmentAddress());
            depart.setDepartmentCode(departmentDto.getDepartmentCode());
            departmentRepository.save(depart);
            return new ResponseDto("OK", "200", "department information is save in the database", depart);
        }catch (Exception excp){;
            throw new GeneralException("500", "department information is not save in database", "");
        }

    }

    @Override
    public ResponseDto findDepartmentById(Long departmentId) throws GeneralException {

        log.info("Inside findDepartmentById of DepartmentService");
        Optional<Department> id = departmentRepository.findById(departmentId);

        if(!id.isPresent()){
            throw new GeneralException("500","Department Id doesn't exist","");
        }
        DepartmentDto depart = new DepartmentDto();
        id.ifPresent(temp ->{
            depart.setDepartmentId(temp.getDepartmentId());
            depart.setDepartmentName(temp.getDepartmentName());
            depart.setDepartmentAddress(temp.getDepartmentAddress());
            depart.setDepartmentCode(temp.getDepartmentCode());
        });
        return new ResponseDto("SUCCESS", "200", "department_details_fetch_successfully", depart);
    }
}
