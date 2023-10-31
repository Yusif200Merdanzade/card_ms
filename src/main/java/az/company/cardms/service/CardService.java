package az.company.cardms.service;

import az.company.cardms.model.CardDto;

import java.util.List;

public interface CardService {

    CardDto getCardById(Long id);

    List<CardDto> getAllByUserId(Long userId);

    CardDto save(CardDto cardDto);

    CardDto delete(Long id);

}
