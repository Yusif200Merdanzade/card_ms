package az.company.cardms.controller;

import az.company.cardms.model.CardDto;
import az.company.cardms.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardController {

    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCardById(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.getCardById(id));
    }

    @GetMapping("user/{userId}")
    public ResponseEntity<?> getAllByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(cardService.getAllByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<?> save(@Valid @RequestBody CardDto dto) {
        return ResponseEntity.ok(cardService.save(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        return ResponseEntity.ok(cardService.delete(id));
    }


}
