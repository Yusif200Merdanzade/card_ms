package az.company.cardms.error;

import az.company.cardms.exception.ErrorResponse;
import org.springframework.http.HttpStatus;


//TODO: yaml messages configuration
public enum ErrorsFinal implements ErrorResponse {
    FILE_ALREADY_EXISTS("FILE_ALREADY_EXISTS", HttpStatus.CONFLICT, "bu yolda {path} file artıq mövcuddur"),
    DATA_NOT_FOUND("DATA_NOT_FOUND", HttpStatus.NOT_FOUND, " id-si '{id}' olan '{name}' məlumatı tapılmadı"),
    STATUS_NOT_FOUND("STATUS_NOT_FOUND", HttpStatus.NOT_FOUND, " '{status}' statusu olan '{name}' məlumatı tapılmadı"),
    DATA_NOT_FOUND_LAST("DATA_NOT_FOUND_LAST", HttpStatus.NOT_FOUND, "{message}"),
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR", HttpStatus.INTERNAL_SERVER_ERROR, "daxili server xətası"),
    SERVICE_TYPE_ERROR("SERVICE_TYPE_ERROR", HttpStatus.BAD_REQUEST, "{message}"),

    ACCESS_DENIED("ACCESS_DENIED", HttpStatus.FORBIDDEN, "İcazə yoxdur"),
    EXPIRED_JWT_ERROR("EXPIRED_JWT_ERROR", HttpStatus.UNAUTHORIZED, "JWT token-in vaxtı keçib"),
    UNSUPPORTED_JWT_ERROR("UNSUPPORTED_JWT_ERROR", HttpStatus.UNAUTHORIZED, "Bu token formatı dəstəklənmir"),
    MALFORMED_JWT_ERROR("MALFORMED_JWT_ERROR", HttpStatus.UNAUTHORIZED, "Token düzgün formatda deyil"),
    SIGNATURE_JWT_ERROR("SIGNATURE_JWT_ERROR", HttpStatus.UNAUTHORIZED, "Token-in signature-i səhvdi"),
    INVALID_TOKEN("INVALID_TOKEN", HttpStatus.UNAUTHORIZED, "Token səhvdi"),
    USERNAME_NOT_FOUND("USER_NOT_FOUND", HttpStatus.UNAUTHORIZED, "User with this username not found"),

    //for standard exception messages
    UNIQUE_CONSTRAINT("23505", HttpStatus.BAD_REQUEST, "id-lər(unikallığa görə) təkrarlana bilməz"),
    FK_CONSTRAINT("23503", HttpStatus.BAD_REQUEST, "əlaqəli olduğu məlumat xətası"),
    NOT_EMPTY_CONSTRAINT("23502", HttpStatus.BAD_REQUEST, "{name} boş ola bilməz"),
    CHECK_VIOLATION("23514", HttpStatus.BAD_REQUEST, "check violation xətası"),

    DATA_IN_USE("DATA_IN_USE", HttpStatus.BAD_REQUEST, " {id} id-li universitet hazırda istifadə olunur");


    final String key;
    final HttpStatus httpStatus;
    final String message;

    ErrorsFinal(String key, HttpStatus httpStatus, String message) {
        this.key = key;
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public String getKey() {
        return key;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}