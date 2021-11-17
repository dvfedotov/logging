package ru.dfed.logging.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.dfed.logging.domain.Message;

@Slf4j
@RestController
public class SignatureController {

    @PostMapping("/api/v1/signature")
    public String getSignedMessage(@RequestBody Message message) {
        log.info("Applying signature to message for username: {}", message.getUsername());
        return message.getHeader() + "\n\n" + message.getBody()
            + "\n\n BR, \n\n" + message.getUsername();
    }
}
