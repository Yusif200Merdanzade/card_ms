package az.company.cardms.mapper;

import az.company.cardms.entity.Card;
import az.company.cardms.model.CardDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "Spring")
public interface CardMapper {


    @Mapping(target ="cardNumber", qualifiedByName = "maskCardNumber")
    @Mapping(target ="cvv", qualifiedByName = "maskCVV")
    CardDto entityToDto(Card card);

    Card dtoToEntity(CardDto cardDto);


    @Named("maskCardNumber")
    default String maskCardNumber(String cardNumber) {
        return cardNumber.substring(0, 6) + "*".repeat(cardNumber.length() - 10) + cardNumber.substring(cardNumber.length() - 4);

    }

    @Named("maskCVV")
    default String maskCVV(int cvv) {
        return "***";
    }
}
