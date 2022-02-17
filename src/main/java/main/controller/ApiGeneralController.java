package main.controller;

import main.api.response.InitResponse;
import main.api.response.SettingsResponse;
import main.api.response.TagResponse;
import main.service.SettingsService;
import main.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {

    private final SettingsService settingsService;
    private final InitResponse initResponse;
    private final TagService tagService;

    public ApiGeneralController(SettingsService settingsService, InitResponse initResponse, TagService tagService) {
        this.settingsService = settingsService;
        this.initResponse = initResponse;
        this.tagService = tagService;
    }

    @GetMapping("/tag")
    private ResponseEntity<TagResponse> tags(){
        return new ResponseEntity<>(this.tagService.getTag(), HttpStatus.OK);
    }

    @GetMapping("/settings")
    private ResponseEntity<SettingsResponse> settings(){
        return new ResponseEntity<>(this.settingsService.getGlobalSettings(), HttpStatus.OK);
    }

    @GetMapping("/init")
    private InitResponse init() {
        return initResponse;
    }
}

