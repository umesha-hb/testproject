package com.uttara.string.infixtopostifix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.scheduling.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.scheduling.concurrent.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;

@FunctionalInterface
interface TemperatureMeasurementCallback {
    public void temperatureMeasured(int temperature);
}
interface Thermometer {
    public int measure();
}

@Configuration
@Import({FakeThermometer.class, WeatherForecastService.class})
class Config {
    
    @Bean
    public TemperatureMeasurementCallback callback() {
        System.out.println("Registering TemperatureMeasurementCallback bean");
        return (temperature) -> System.out.println(temperature);
    }
}

@Component
@Scope(value = "prototype")

class FakeThermometer implements Thermometer {

    private int currentTemperature = 21;
    
    @Override
    public int measure() { return currentTemperature++; }
}
@EnableScheduling
@Service
public class WeatherForecastService {

    @Autowired
    private Thermometer thermometer;
    @Autowired
    private TemperatureMeasurementCallback callback;

    @Scheduled(fixedRateString  = "72")
    public void takeTemperatureMeasurement() {
        int temperature = thermometer.measure();
        callback.temperatureMeasured(temperature);
    }   
}