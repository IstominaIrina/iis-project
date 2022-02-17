package main.controller;

import main.api.response.CheckResponse;
import main.api.response.SettingsResponse;
import main.service.CheckService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class ApiAuthController {

    private final CheckService checkService;

    public ApiAuthController(CheckService checkService) {
        this.checkService = checkService;
    }

    @GetMapping("/check")
    private ResponseEntity<CheckResponse> check(){
        return new ResponseEntity<>(this.checkService.getAuthCheck(), HttpStatus.OK);
    }
}
