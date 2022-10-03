package pw.cyberbrain.smsreceiverbackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pw.cyberbrain.smsreceiverbackend.domain.Template;
import pw.cyberbrain.smsreceiverbackend.repository.TemplateRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TemplateController {

    @Autowired
    private TemplateRepository templateRepository;

    @GetMapping(value = "/templates", produces = "application/json")
    List<Template> getAllTemplates() {
        List<Template> templates = new ArrayList<>();
        if (templateRepository.findAll().iterator().hasNext()) {
            templateRepository.findAll().iterator().forEachRemaining(templates::add);
        }
        return templates;
    }
}
