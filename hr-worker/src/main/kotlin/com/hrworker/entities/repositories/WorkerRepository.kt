package com.hrworker.entities.repositories

import com.hrworker.entities.domain.Worker
import org.springframework.data.jpa.repository.JpaRepository

interface WorkerRepository : JpaRepository<Worker, Long> {
}