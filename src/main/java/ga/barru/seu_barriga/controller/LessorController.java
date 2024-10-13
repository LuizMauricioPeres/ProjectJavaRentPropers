package ga.barru.seu_barriga.controller;

import ga.barru.seu_barriga.model.Lessor;
import ga.barru.seu_barriga.services.LessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lessor")
public class LessorController {

    private  final LessorService lessorService;

    @Autowired
    public LessorController(LessorService lessorService) {
        this.lessorService = lessorService;
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<Lessor>> findAll() {
        List<Lessor> lessors = this.lessorService.findAll();
        return ResponseEntity.ok(lessors);
    }

}

