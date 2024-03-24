package ru.geekbrains.webage.services;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

@Service
public class DataProcessingService {
    ChronoUnit[] units = {ChronoUnit.YEARS, ChronoUnit.MONTHS, ChronoUnit.WEEKS, ChronoUnit.DAYS};

    public List<Long> getDurations(LocalDate birthDate) {

        List<Long> ages = new ArrayList<>();
        for (ChronoUnit value : units) {
            ages.add(value.between(birthDate, LocalDate.now()));
        }

        return ages;
    }
}
