package swf.army.mil.dealership.inventory;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {


    private CarRepository carRepository;

    public CarService(CarRepository carRepository) {

        this.carRepository = carRepository;
    }

    public List<Car> getAvailableCars() {
        return carRepository.findAll();
    }
}
