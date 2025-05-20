package com.wfo_exception_tracker.wfo_exception_tracker.service

import com.wfo_exception_tracker.wfo_exception_tracker.dto.EmployeeDto
import com.wfo_exception_tracker.wfo_exception_tracker.entity.Employee
import com.wfo_exception_tracker.wfo_exception_tracker.repository.EmployeeRepository
import org.springframework.stereotype.Service

@Service
class EmployeeService(
    private val employeeRepository: EmployeeRepository
) {
    fun saveAll(employees: List<EmployeeDto>) {
        val employeeEntities = employees.map {
            Employee(
                Expedia_fG_Name=it.Expedia_fG_Name,
                ibsEmpId =it.ibsEmpId,
                JL=it.JL,
                Role=it.Role,
                Rate=it.Rate,
                HM=it.HM,
                Country=it.Country,
                Location=it.Location,
                SOW=it.SOW,
                SVP_Org=it.SVP_Org,
                VP_Org=it.VP_Org,
                Director_Org=it.Director_Org,
                Team=it.Team,
                TeamOwner=it.TeamOwner,
                TeamOwnerID=it.TeamOwnerID,
                DM=it.DM,
                DM_ID=it.DM_ID,
                Billiability=it.Billiability,
                Remarks=it.Remarks
            )
        }
        employeeRepository.saveAll(employeeEntities)
    }
}