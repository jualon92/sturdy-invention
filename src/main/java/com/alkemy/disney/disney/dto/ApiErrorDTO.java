package com.alkemy.disney.disney.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
@AllArgsConstructor

public class ApiErrorDTO {
    private HttpStatus status;
    private String message;
    private List<String> errror;
}
