package az.company.cardms.model;



import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CardDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Long id;

    @Pattern(regexp = "^[0-9]{16}$", message = "Card number must be a 16-digit number")
    String cardNumber;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    LocalDate expirationDate;

    @Min(value = 0, message = "CVV must be at least 0.")
    @Max(value = 999, message = "CVV cannot exceed 999.")
    String cvv;

    @Min(value = 0, message = "Balance must be at least 0.")
    double balance;

    Long userId;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    Character status = '1';

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy HH:mm:ss")
    private LocalDateTime updateDate;
}
