package com.codegym.common;

import com.codegym.dto.UserDto;
import org.springframework.validation.Errors;

import java.time.LocalDate;
import java.time.Period;

public class DateOfBirthUtil {

    public static void checkAge(UserDto userDto , Errors errors){
        String date = userDto.getAge();
        LocalDate localDate;
        int year = 0;
        try {
            localDate = LocalDate.parse(date);
            Period period = Period.between(localDate, LocalDate.now());
            year = period.getYears();
        } catch (Exception e) {
            errors.rejectValue("age", "ageValidate", "Nhập đúng định dạng");
        }

        if (year < 18) {
            errors.rejectValue("age", "ageValidate", "Chưa đủ 18 tuổi");
        }
    }
}
