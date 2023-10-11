package com.emiryanvl.diskaccounting.entity

import jakarta.persistence.*

@Entity
@Table(name = "_city")
class City (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var title: String,
    @Column(name = "is_rented")
    var isRented: Boolean
)