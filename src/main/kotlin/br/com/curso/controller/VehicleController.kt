package br.com.curso.controller

import br.com.curso.model.Vehicle
import br.com.curso.service.VehicleService
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import java.util.Optional

@Controller("/vehicle")
class VehicleController(
    private val vehicleService: VehicleService
) {

    @Get
    fun getAll(): HttpResponse<MutableList<Vehicle>> = HttpResponse.ok(vehicleService.getAll())

    @Post
    fun create(@Body vehicle: Vehicle): HttpResponse<Vehicle> = HttpResponse.created(vehicleService.create(vehicle))

    @Get("/{id}")
    fun findById(@PathVariable id: Long): HttpResponse<Optional<Vehicle>> = HttpResponse.ok(vehicleService.findById(id))

    @Put
    fun update(@Body vehicle: Vehicle): HttpResponse<Vehicle> = HttpResponse.ok(vehicleService.update(vehicle))

    @Delete("/{id}")
    fun delete(@PathVariable id: Long): HttpResponse<Unit> = HttpResponse.ok(vehicleService.delete(id))
}