package com.automation.ui.pojo.ipl;

import lombok.Data;

import java.util.List;

@Data
public class IplStats {

    private String teamName;
    private String category;
    private List<PlayerStats> players;
}
