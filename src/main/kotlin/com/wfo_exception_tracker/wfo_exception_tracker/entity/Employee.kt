package com.wfo_exception_tracker.wfo_exception_tracker.entity

import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
@Entity
@Table(name = "employees")
data class Employee(
    val Expedia_fG_Name:String,
    @Id
    val ibsEmpId: Long,
    val JL: String,
    val Role: String,
    val Rate:String,
    val HM:String,
    val Country:String,
    val Location:String,
    val SOW:String,
    val SVP_Org:String,
    val VP_Org:String,
    val Director_Org:String,
    val Team:String,
    val TeamOwner:String,
    val TeamOwnerID:Long,
    val DM:String,
    val DM_ID:Long,
    val Billiability:String,
    val Remarks:String

)