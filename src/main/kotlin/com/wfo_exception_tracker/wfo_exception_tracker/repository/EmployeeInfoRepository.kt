package com.wfo_exception_tracker.wfo_exception_tracker.repository



import com.wfo_exception_tracker.wfo_exception_tracker.entity.EmployeeInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EmployeeInfoRepository : JpaRepository<EmployeeInfo, Long> {
    fun findByadminVerifiedFalse(): List<EmployeeInfo>
}
