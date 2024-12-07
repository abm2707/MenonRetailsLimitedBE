package com.example.menonRetailsLtd.DTOs;

import lombok.Data;
import org.springframework.web.bind.annotation.ModelAttribute;

@Data
public class ScreenModel {
    private final String screenName;
    private final String screenPath;

    public ScreenModel(String screenName, String screenPath) {
        this.screenName = screenName;
        this.screenPath = screenPath;
    }
}
