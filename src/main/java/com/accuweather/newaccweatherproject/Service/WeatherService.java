package com.accuweather.newaccweatherproject.service;

import com.accuweather.newaccweatherproject.exception.NewAccuWeatherException;
import com.accuweather.newaccweatherproject.model.DailyForecast;
import com.accuweather.newaccweatherproject.model.Day;
import com.accuweather.newaccweatherproject.model.Night;
import com.accuweather.newaccweatherproject.model.request.SearchDayRequest;
import lombok.RequiredArgsConstructor;
import com.accuweather.newaccweatherproject.model.Forecast;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.message.TimestampMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.accuweather.newaccweatherproject.constant.AppConstant.*;

@Slf4j
@Service
@RequiredArgsConstructor
public class WeatherService {

    // TODO :: Create Bean by creating config package and inject them here.
    // Don't use @Value
    @Value("${external.api.url}")
    private String apiUrl;

    @Autowired
    private final RestTemplate restTemplate;

    public Forecast getWeather() {
        // Use loggers instead of sysout :
        // Use Response(create if not exists) Object instead of Forecast
        System.out.println("API URL: " + apiUrl);
        try {
            return restTemplate.getForObject(apiUrl, Forecast.class);
        } catch (Exception e) {// TODO :: create custom exception class and handle it using ExceptionHandle
            e.printStackTrace();
        }
        return null; // Don't return null object reject empty response Object.
    }

    /**
     * This method used for retriving days from forcast
     *
     * @return
     */
    public List<Day> getDays() {
        List<Day> days = new ArrayList<Day>();
        Forecast forecast = getWeather();
        List<DailyForecast> dailyForecastList = forecast.getDailyForecasts();
        for (DailyForecast dailyForecast : dailyForecastList) {
            Day day = dailyForecast.getDay();
            days.add(day);
        }

        return days;
    }

    public List<Day> filterIcon(List<Day> dailyForecastList) {
        List<Day> filteredList = new ArrayList<>();

        for (Day details : dailyForecastList) {
            int iconValue = details.getIcon();//
            if (iconValue > 30) {
                filteredList.add(details);
            }
        }

        return filteredList;
    }


    public List<Day> filterIconPhrase(List<Day> dailyForecastList) {
        List<Day> filteredPhrase = new ArrayList<>();

        for (Day phrase : dailyForecastList) {
            String phraseValue = phrase.getIconPhrase();
            if (phraseValue.equalsIgnoreCase("cold")) {
                filteredPhrase.add(phrase);
            }
        }

        return filteredPhrase;
    }

    // handle exception here using exception handler
//    https://www.baeldung.com/exception-handling-for-rest-with-spring#controlleradvice
    public List<Day> filterBeforeException(SearchDayRequest searchDayRequest) {
        List<Day> filtered = new ArrayList<>();
        String key = searchDayRequest.getKey();
//            if key equals to iconphrase then filter days based on request value
        //write similar logic as IconPhrase for Icon and HasPrecipitation
        if (key.equalsIgnoreCase(ICON_PHRASE)) {
            String requestValue = searchDayRequest.getValue();
            List<Day> days = getDays();
            for (Day day : days) {
                if (requestValue.equalsIgnoreCase(day.getIconPhrase())) {
                    filtered.add(day);
                }
            }
        }
        if (key.equalsIgnoreCase(ICON)) {
            String icon = searchDayRequest.getValue();
            List<Day> days = getDays();
            for (Day day : days) {
                if (icon.equalsIgnoreCase(day.getIcon().toString())) {
                    filtered.add(day);
                }
            }
        }
        if (key.equalsIgnoreCase(HAS_PRECIPITATION)) {
            String has = searchDayRequest.getValue();
            List<Day> days = getDays();
            for (Day day : days) {
                if (has.equalsIgnoreCase(day.getHasPrecipitation().toString())) {
                    filtered.add(day);
                }
            }
        }
        return filtered;
    }

    public List<Day> filter(SearchDayRequest searchDayRequest) throws NewAccuWeatherException {
        List<Day> filtered = new ArrayList<>();
        String key = searchDayRequest.getKey();
//            if key equals to iconphrase then filter days based on request value
        //write similar logic as IconPhrase for Icon and HasPrecipitation
        try{
            if (key.equalsIgnoreCase(ICON_PHRASE)) {
                String requestValue = searchDayRequest.getValue();
                List<Day> days = getDays();
                for (Day day : days) {
                    if (requestValue.equalsIgnoreCase(day.getIconPhrase())) {
                        filtered.add(day);
                    }
                }
            }
            if (key.equalsIgnoreCase(ICON)) {
                String icon = searchDayRequest.getValue();
                List<Day> days = getDays();
                for (Day day : days) {
                    if (icon.equalsIgnoreCase(day.getIcon().toString())) {
                        filtered.add(day);
                    }
                }
            }
            if (key.equalsIgnoreCase(HAS_PRECIPITATION)) {
                String has = searchDayRequest.getValue();
                List<Day> days = getDays();
                for (Day day : days) {
                    if (has.equalsIgnoreCase(day.getHasPrecipitation().toString())) {
                        filtered.add(day);
                    }
                }
            }
        }catch(Exception exception){
            log.error("Exception occurred at filter method with reason {}", exception.getMessage());
            throw new NewAccuWeatherException("imtiyaz is hero","uri", HttpStatus.PRECONDITION_FAILED,"description");
        }

        return filtered;
    }

    public List<Night> getNight() {
        List<Night> nights = new ArrayList<>();
        Forecast forecast = getWeather();
        List<DailyForecast> dailyForecastList = forecast.getDailyForecasts();
        for (DailyForecast dailyForecast : dailyForecastList) {
            Night night = dailyForecast.getNight();
            nights.add(night);
        }
        return nights;
    }

    public List<Night> nightIcon(List<Night> dailyForecastList) {
        List<Night> filteredList = new ArrayList<>();

        for (Night details : dailyForecastList) {
            int iconValue = details.getIcon();
            if (iconValue > 30) {
                filteredList.add(details);
            }
        }

        return filteredList;
    }

    /**
     * This method used to get IconPhrase value form Night  object.
     *
     * @param dailyForecast
     * @return filteredIconPhrase
     */

    public List<Night> nightIconPhrase(List<Night> dailyForecast) {
        List<Night> filteredIconPhrase = new ArrayList<>();

        for (Night iconPhrase : dailyForecast) {
            String phraseValue = iconPhrase.getIconPhrase();
            if (phraseValue.equalsIgnoreCase("Mostly clear")) {
                filteredIconPhrase.add(iconPhrase);
            }
        }
        return filteredIconPhrase;
    }
}













