package com.hrworker.entities.domain

import javax.persistence.*

@Entity
@Table(name = "tb_worker")
class Worker(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    val id: Long? = 0L,

    @Column(name = "name")
    val name: String? = "",

    @Column(name = "dailyIncome")
    val dailyIncome: Double? = 0.0
)