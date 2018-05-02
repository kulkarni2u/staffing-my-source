package com.casper.staffing.service;

import com.casper.staffing.model.Template;

import java.util.List;

public interface TemplateService {
    List<Template> getAllTemplates();
    List<Template> getAllTemplates(int page, int pageSize, String sortBy, String direction);
    List<Template> getAllVisibleTemplates();
    Template getTemplateById(String templateId);
    Template createOrUpdateTemplate(Template template);
}
