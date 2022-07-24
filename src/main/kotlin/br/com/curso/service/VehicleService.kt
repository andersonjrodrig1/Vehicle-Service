package br.com.curso.service

import br.com.curso.model.Vehicle
import br.com.curso.repository.VehicleRepository
import jakarta.inject.Singleton
import java.util.Optional

@Singleton
class VehicleService(
    private val vehicleRepository: VehicleRepository
) {

    fun getAll(): MutableList<Vehicle> = vehicleRepository.findAll()

    fun create(vehicle: Vehicle): Vehicle = vehicleRepository.save(vehicle)

    fun findById(id: Long): Optional<Vehicle> = vehicleRepository.findById(id)

    fun update(vehicle: Vehicle): Vehicle = vehicleRepository.update(vehicle)

    fun delete(id: Long) = vehicleRepository.deleteById(id)
}