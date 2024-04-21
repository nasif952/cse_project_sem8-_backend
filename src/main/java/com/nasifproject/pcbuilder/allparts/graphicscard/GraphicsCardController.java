package com.nasifproject.pcbuilder.allparts.graphicscard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/graphicscard")
public class GraphicsCardController {

    @Autowired
    private GraphicsCardRepository graphicsCardRepository;

    @GetMapping
    public ResponseEntity<List<GraphicsCard>> getAllGraphicsCards() {
        List<GraphicsCard> graphicsCards = graphicsCardRepository.findAll();
        return ResponseEntity.ok(graphicsCards);
    }

    @PostMapping
    public ResponseEntity<GraphicsCard> addGraphicsCard(@RequestBody GraphicsCard graphicsCard) {
        try {
            GraphicsCard savedGraphicsCard = graphicsCardRepository.save(graphicsCard);
            return ResponseEntity.ok(savedGraphicsCard);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteGraphicsCard(@PathVariable String id) {
        try {
            graphicsCardRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<GraphicsCard> updateGraphicsCard(@PathVariable String id, @RequestBody GraphicsCard graphicsCardDetails) {
        Optional<GraphicsCard> graphicsCardOptional = graphicsCardRepository.findById(id);

        if (!graphicsCardOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        GraphicsCard graphicsCard = graphicsCardOptional.get();
        graphicsCard.setName(graphicsCardDetails.getName());
        graphicsCard.setBrand(graphicsCardDetails.getBrand());
        graphicsCard.setGb(graphicsCardDetails.getGb());
        graphicsCard.setWattage(graphicsCardDetails.getWattage());
        graphicsCard.setCost(graphicsCardDetails.getCost());
        graphicsCard.setImageLink(graphicsCardDetails.getImageLink());

        GraphicsCard updatedGraphicsCard = graphicsCardRepository.save(graphicsCard);
        return ResponseEntity.ok(updatedGraphicsCard);
    }
}
