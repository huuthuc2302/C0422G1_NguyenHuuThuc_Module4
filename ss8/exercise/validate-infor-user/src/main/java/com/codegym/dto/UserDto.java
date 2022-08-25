package com.codegym.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.Period;

public class UserDto implements Validator {

    private Integer idUser;

    @NotBlank(message = "Vui lòng nhập ")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank(message = "Vui lòng nhập ")
    @Size(min = 5, max = 45)
    private String lastName;

    @NotBlank(message = "Vui lòng nhập số")
    @Pattern(regexp = "^(0|\\+84)\\d{9}$", message = "Nhập sai kiểu")
    private String phone;

    @NotBlank(message = "Vui lòng nhập")
    private String age;

    @Email
    private String email;

    public UserDto() {
    }

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        String date = userDto.age;
        LocalDate localDate;
        int year = 0;
        try {
            localDate = LocalDate.parse(date);
            Period period = Period.between(localDate, LocalDate.now());
            year = period.getYears();
        } catch (Exception e) {
            errors.rejectValue("age", "ageValidate", "Nhập ddungs định dạng");
        }

        if (year < 18) {
            errors.rejectValue("age", "ageValidate", "Chưa đủ 18 tuổi");
        }
    }
}
