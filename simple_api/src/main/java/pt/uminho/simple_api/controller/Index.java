package pt.uminho.simple_api.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.time.Instant;

@RestController
@CrossOrigin(origins = "*")
public class Index {

    private Logger log = LogManager.getLogger(Index.class);

    @GetMapping("/")
    public String index() {
        return Date.from(Instant.now()).toString();
    }

}
