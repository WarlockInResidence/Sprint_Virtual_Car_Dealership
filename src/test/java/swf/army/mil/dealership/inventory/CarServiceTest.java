package swf.army.mil.dealership.inventory;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

public class CarServiceTest {

    @Test
    void should_return_a_list_of_cars() {
        // arrange
        Car car1 = Mockito.mock(Car.class);
        Car car2 = Mockito.mock(Car.class);
        Car car3 = Mockito.mock(Car.class);
        List<Car> cars = List.of(car1, car2, car3);
        CarRepository carRepository = Mockito.mock(CarRepository.class);
        when(carRepository.findAll()).thenReturn(cars);
        CarService service = new CarService(carRepository);

        // act
        List<Car> availableCars = service.getAvailableCars();

        // assert
        assertEquals(availableCars.size(), 3);
    }


}
