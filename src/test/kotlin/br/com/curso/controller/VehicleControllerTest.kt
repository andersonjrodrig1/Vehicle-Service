package br.com.curso.controller

import br.com.curso.model.Vehicle
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class VehicleControllerTest: FunSpec({

    val vehicleControllerMock = mockk<VehicleController>()
    val vehicleMock = mockk<Vehicle>()
    val listVehicle = listOf(
        Vehicle(
            id = 1,
            model = "modelo test1",
            brand = "marca test1",
            plaque = "TTT 1234"
        )
    )
    val vehicle = Vehicle(
        id = 1,
        model = "modelo test1",
        brand = "marca test1",
        plaque = "TTT 1234"
    )

    test("test getAll controller") {
        every {
            vehicleControllerMock.getAll()
        } returns HttpResponse.ok(
            mutableListOf(
                Vehicle(
                    id = 1,
                    model = "modelo test1",
                    brand = "marca test1",
                    plaque = "TTT 1234"
                )
            )
        )

        val result = vehicleControllerMock.getAll()

        result.status shouldBe HttpStatus.OK
        result.body shouldBe Optional.of(listVehicle)
    }

    test("test post controller") {
        every {
            vehicleControllerMock.create(vehicle = vehicleMock)
        } returns HttpResponse.created(
            Vehicle(
                id = 1,
                model = "modelo test1",
                brand = "marca test1",
                plaque = "TTT 1234"
            )
        )

        val result = vehicleControllerMock.create(vehicle = vehicleMock)

        result.status shouldBe HttpStatus.CREATED
        result.body shouldBe Optional.of(vehicle)
    }

    test("test findById controller") {
        every {
            vehicleControllerMock.findById(id = 1)
        } returns HttpResponse.ok(
            Optional.of(
                Vehicle(
                    id = 1,
                    model = "modelo test1",
                    brand = "marca test1",
                    plaque = "TTT 1234"
                )
            )
        )

        val result = vehicleControllerMock.findById(id = 1)

        result.status shouldBe HttpStatus.OK
        result.body shouldBe Optional.of(
            Optional.of(vehicle)
        )
    }

    test("test update controller") {
        every {
            vehicleControllerMock.update(vehicle = vehicleMock)
        } returns HttpResponse.ok(
            Vehicle(
                id = 1,
                model = "modelo test1",
                brand = "marca test1",
                plaque = "TTT 1234"
            )
        )

        val result = vehicleControllerMock.update(vehicle = vehicleMock)

        result.status shouldBe HttpStatus.OK
        result.body shouldBe Optional.of(vehicle)
    }

    test("test delete controller") {
        every {
            vehicleControllerMock.delete(id = 1)
        } returns HttpResponse.ok()

        val result = vehicleControllerMock.delete(id = 1)

        result.status shouldBe HttpStatus.OK
    }

})