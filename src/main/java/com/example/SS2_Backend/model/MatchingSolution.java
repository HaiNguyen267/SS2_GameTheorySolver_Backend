package com.example.SS2_Backend.model;

import com.example.SS2_Backend.dto.response.ComputerSpecs;
import com.example.SS2_Backend.model.GameSolution;
import com.example.SS2_Backend.util.ComputerSpecsUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class MatchingSolution {
    private double fitnessValue;
    private List<GameSolution.Player> players;
    private String algorithm;
    private double runtime;

//    private ComputerSpecs computerSpecs;
//
//    public ComputerSpecs getComputerSpecs() {
//        return ComputerSpecsUtil.getComputerSpecs();
//    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Individual {
//        private String playerName;
//        private String strategyName;
//        private double payoff;
    }
}
