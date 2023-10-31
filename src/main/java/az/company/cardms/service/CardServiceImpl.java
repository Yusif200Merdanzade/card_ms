package az.company.cardms.service;

import az.company.cardms.entity.Card;
import az.company.cardms.error.ErrorsFinal;
import az.company.cardms.exception.ApplicationException;
import az.company.cardms.mapper.CardMapper;
import az.company.cardms.model.CardDto;
import az.company.cardms.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    @Override
    public CardDto getCardById(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new ApplicationException(ErrorsFinal.DATA_NOT_FOUND, Map.of("id", id)));
        return cardMapper.entityToDto(card);
    }

    @Override
    public List<CardDto> getAllByUserId(Long userId) {
        List<Card> cards = cardRepository.findAllByUserIdAndStatus(userId,'1');
        return cards.stream()
                .map(cardMapper::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public CardDto save(CardDto cardDto) {
        Card card = cardMapper.dtoToEntity(cardDto);
        cardRepository.save(card);
        return cardMapper.entityToDto(card);
    }

    @Override
    public CardDto delete(Long id) {
        Card card = cardRepository.findById(id).orElseThrow(() -> new ApplicationException(ErrorsFinal.DATA_NOT_FOUND, Map.of("id", id)));
        cardRepository.delete(card);
        return cardMapper.entityToDto(card);
    }
}
