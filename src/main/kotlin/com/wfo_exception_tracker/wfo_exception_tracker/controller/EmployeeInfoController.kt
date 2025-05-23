package com.wfo_exception_tracker.wfo_exception_tracker.controller



import com.wfo_exception_tracker.wfo_exception_tracker.service.EmployeeInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/api/admin")
class EmployeeInfoController(
    private val employeeInfoService: EmployeeInfoService
) {

    @GetMapping("/pending-requests")
    fun getPendingEmployees() = ResponseEntity.ok(employeeInfoService.getPendingRequests())

    @PostMapping("/verify/{ibsEmpId}")
    fun verifyEmployee(@PathVariable ibsEmpId: Long): ResponseEntity<String> {
        return if (employeeInfoService.verifyEmployee(ibsEmpId)) {
            ResponseEntity.ok("Employee $ibsEmpId verified successfully.")
        } else {
            ResponseEntity.badRequest().body("Employee $ibsEmpId not found.")
        }
    }
}
