package com.example.SS2_Backend.controller;

import com.example.SS2_Backend.dto.request.GameTheoryProblemDTO;
import com.example.SS2_Backend.dto.request.StableMatchingProblemDTO;
import com.example.SS2_Backend.dto.response.Response;
import com.example.SS2_Backend.model.StableMatching.StableMatchingProblem;
import com.example.SS2_Backend.service.GameTheorySolver;
import com.example.SS2_Backend.service.StableMatchingSolver;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.SS2_Backend.service.StableMatchingSolver.convertObjectToJson;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class HomeController {

    public ResponseEntity<Response> dataFromWeb;

    @Autowired
    private GameTheorySolver gameTheorySolver;
    private StableMatchingSolver stableMatchingSolver;

    @PostMapping("/stable-matching-solver")
    public ResponseEntity<Response> getJson(@RequestBody Object object) {
            ObjectMapper OM = new ObjectMapper();
            StableMatchingProblemDTO problemDTO = OM.convertValue(object, StableMatchingProblemDTO.class);
            ResponseEntity<Response> r = StableMatchingSolver.solveStableMatching(problemDTO);
            dataFromWeb = StableMatchingSolver.getUIResult(problemDTO);
            return r;
    }

    @GetMapping("/stable-matching-result")
    public ResponseEntity<Response> getNameList() {
        return dataFromWeb;
    }

    @PostMapping("/game-theory-solver")
    public ResponseEntity<Response> solveGameTheory(@RequestBody GameTheoryProblemDTO gameTheoryProblem) {
        return gameTheorySolver.solveGameTheory(gameTheoryProblem);
    }

    @PostMapping("/problem-result-insights/{sessionCode}")
    public ResponseEntity<Response> getProblemResultInsights(@RequestBody GameTheoryProblemDTO gameTheoryProblem, @PathVariable String sessionCode) {
       return gameTheorySolver.getProblemResultInsights(gameTheoryProblem, sessionCode);
    }
}