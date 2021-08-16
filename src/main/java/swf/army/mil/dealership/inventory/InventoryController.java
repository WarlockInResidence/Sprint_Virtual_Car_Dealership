package swf.army.mil.dealership.inventory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {
    private CarService carService;

    public InventoryController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/inventory/cars")
    public @ResponseBody List<Car> cars() {
        return carService.getAvailableCars();
    }

}
