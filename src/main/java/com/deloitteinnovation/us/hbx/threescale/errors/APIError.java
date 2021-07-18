package com.deloitteinnovation.us.hbx.threescale.errors;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import org.springframework.http.HttpStatus;
import java.time.LocalDateTime;

@Data
@JsonTypeInfo(include = JsonTypeInfo.As.WRAPPER_OBJECT, use = JsonTypeInfo.Id.CUSTOM, property = "error", visible = true)
class APIError {

    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;

    private APIError() {
        timestamp = LocalDateTime.now();
    }

    APIError(HttpStatus status) {
        this();
        this.status = status;
    }
}