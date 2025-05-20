package com.wfo_exception_tracker.wfo_exception_tracker.service



import com.wfo_exception_tracker.wfo_exception_tracker.entity.EmployeeInfo
import com.wfo_exception_tracker.wfo_exception_tracker.repository.EmployeeInfoRepository
import org.springframework.stereotype.Service

@Service
class EmployeeInfoService(private val repository: EmployeeInfoRepository) {

    fun getPendingRequests(): List<EmployeeInfo> {
        return repository.findByadminVerifiedFalse()
    }

    fun verifyEmployee(ibsEmpId: Long): Boolean {
        val employee = repository.findById(ibsEmpId)
        if (employee.isPresent) {
            val verifiedEmployee = employee.get().copy(adminVerified = true)
            repository.save(verifiedEmployee)
            return true
        }
        return false
    }
}
