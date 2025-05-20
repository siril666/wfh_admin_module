package com.wfo_exception_tracker.wfo_exception_tracker.controller



import com.wfo_exception_tracker.wfo_exception_tracker.dto.EmployeeDto
import com.wfo_exception_tracker.wfo_exception_tracker.service.EmployeeService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["http://localhost:5174"]) // Adjust based on your frontend port
@RestController
@RequestMapping("/api/employees")
class EmployeeController(
    private val employeeService: EmployeeService
) {
    @PostMapping("/upload")
    fun uploadEmployees(@RequestBody employees: List<EmployeeDto>): ResponseEntity<String> {
        if (employees.isEmpty()) {
            return ResponseEntity.badRequest().body("Empty data received")
        }

        println("Received Employees: $employees") // Debug log

        try {
            employeeService.saveAll(employees)
        } catch (e: Exception) {
            return ResponseEntity.status(500).body("Failed to upload data: ${e.message}")
        }

        return ResponseEntity.ok("Employee data uploaded successfully")
    }
}
