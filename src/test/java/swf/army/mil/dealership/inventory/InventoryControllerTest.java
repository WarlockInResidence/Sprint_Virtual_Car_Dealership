package swf.army.mil.dealership.inventory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = InventoryController.class)
public class InventoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    CarService carService;

    @Test
    public void shouldGetResponseFromController() throws Exception {

        InventoryController inventoryController = new InventoryController(carService);

        mockMvc.perform(get("/inventory/cars"))
                .andExpect(content().contentType("application/json"))
                .andExpect(status().isOk());

        Mockito.verify(carService).getAvailableCars();
    }
}
