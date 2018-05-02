package com.casper.staffing.controller;

import com.casper.staffing.model.Template;
import com.casper.staffing.model.TemplateFile;
import com.casper.staffing.service.TemplateService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/rest/templates")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TemplateController {
    @NonNull
    private TemplateService templateService;

    @GetMapping("/")
    public List<Template> getAllTemplates() {
        return templateService.getAllTemplates();
    }

    @GetMapping("/active")
    public List<Template> getAllActive() {
        return templateService.getAllVisibleTemplates();
    }

    @GetMapping("/{id}")
    public Template getTemplateById(@PathVariable("id") final String id) {
        return templateService.getTemplateById(id);
    }

    @PutMapping("/template")
    public Template updateTemplate(@RequestBody final Template template) {
        return templateService.createOrUpdateTemplate(template);
    }

    @PostMapping("/template")
    public Template createTemplate(@RequestBody final Template template) {
        return templateService.createOrUpdateTemplate(template);
    }

    @PostMapping("/createOrReplaceTemplate")
    public TemplateFile createOrReplaceTemplateFile(
            @RequestPart(value = "file") final MultipartFile file,
            @RequestBody final TemplateFile templateFile) {


        return null;
    }


}
