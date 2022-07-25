package br.com.curso.service

import br.com.curso.model.Vehicle
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertTrue
import java.util.*

@MicronautTest
class VehicleServiceTest: FunSpec({

    val vehicleServiceMock = mockk<VehicleService>()
    val vehicleMock = mockk<Vehicle>()
    val listVehicle = mutableListOf(
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

    test("test getAll service") {
        every {
            vehicleServiceMock.getAll()
        } returns mutableListOf(
            Vehicle(
                id = 1,
                model = "modelo test1",
                brand = "marca test1",
                plaque = "TTT 1234"
            )
        )

        val result = vehicleServiceMock.getAll()

        result shouldBe listVehicle
    }

    test("test create service") {
        every {
            vehicleServiceMock.create(vehicle = vehicleMock)
        } returns Vehicle(
            id = 1,
            model = "modelo test1",
            brand = "marca test1",
            plaque = "TTT 1234"
        )

        val result = vehicleServiceMock.create(vehicle = vehicleMock)

        result shouldBe vehicle
    }

    test("test findById service") {
        every {
            vehicleServiceMock.findById(id = 1)
        } returns Optional.of(
            Vehicle(
                id = 1,
                model = "modelo test1",
                brand = "marca test1",
                plaque = "TTT 1234"
            )
        )

        val result = vehicleServiceMock.findById(id = 1)

        result shouldBe Optional.of(vehicle)
    }

    test("test update service") {
        every {
            vehicleServiceMock.update(vehicle = vehicleMock)
        } returns Vehicle(
            id = 1,
            model = "modelo test1",
            brand = "marca test1",
            plaque = "TTT 1234"
        )

        val result = vehicleServiceMock.update(vehicle = vehicleMock)

        result shouldBe vehicle
    }

    test("test delete service") {
        every {
            vehicleServiceMock.delete(id = 1)
        } returns Unit

        vehicleServiceMock.delete(id = 1)

        assertTrue(true)
    }

})
