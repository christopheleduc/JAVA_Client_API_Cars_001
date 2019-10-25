package com.vues_thymeleaf.vues_thymeleaf.controller;

import com.vues_thymeleaf.vues_thymeleaf.form.CarForm;
import com.vues_thymeleaf.vues_thymeleaf.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

//    private static List<Car> cars = new ArrayList<Car>();

    private RestTemplate restTemplate = new RestTemplate();

//    static {
//        cars.add(new Car("Aventador SVJ", "Lamborghini"));
//        cars.add(new Car("Huracàn EVO Spyder", "Lamborghini"));
//    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String carList(Model model) {


        Car[] cars = restTemplate.getForObject("http://127.0.0.1:9090/Cars/", Car[].class);
        model.addAttribute("cars", cars);

        return "carList";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveCar(Model model, //
                             @ModelAttribute("carForm") CarForm carForm) {

        String carName = carForm.getCarName();
        String modelName = carForm.getModelName();

        if (carName != null && carName.length() > 0 //
                && modelName != null && modelName.length() > 0) {
            Car newCar = new Car(carName, modelName);
            restTemplate.postForObject("http://127.0.0.1:9090/Cars", newCar, Car.class);
            //cars.add(newCar);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }
}
