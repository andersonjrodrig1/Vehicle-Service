package br.com.curso.repository

import br.com.curso.model.Vehicle
import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface VehicleRepository: JpaRepository<Vehicle, Long> { }