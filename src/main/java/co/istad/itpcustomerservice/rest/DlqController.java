package co.istad.itpcustomerservice.rest;

import co.istad.itpcustomerservice.application.config.DeadLetterProcessor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/dlq")
@RequiredArgsConstructor
public class DlqController {

    private final DeadLetterProcessor deadLetterProcessor;

    @PostMapping("/{processingGroup}/any")
    public Boolean handle(@PathVariable String processingGroup){
        return deadLetterProcessor.processorAnyFor(processingGroup).join();
    }
}
