package com.example.SS2_Backend.dto.request;

import com.example.SS2_Backend.model.Conflict;
import com.example.SS2_Backend.model.NormalPlayer;
import com.example.SS2_Backend.model.SpecialPlayer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameTheoryProblemDTO {
    private SpecialPlayer specialPlayer;
    private List<NormalPlayer> normalPlayers;
    private List<Conflict> conflictSet = new ArrayList<>();
    private String fitnessFunction;
    private String defaultPayoffFunction;
}
