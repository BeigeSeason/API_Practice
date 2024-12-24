package com.ApiEx.PracticeAPI.Controller;

import com.ApiEx.PracticeAPI.Config.BusAPI;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
@RequestMapping("/test")
public class BusController {
    private final BusAPI busAPI;

    @GetMapping("/all-testing")
    public void busTest() throws IOException {
        busAPI.terminalList();
    }
}
