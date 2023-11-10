package com.casper.staffing.service.impl;

import com.casper.staffing.model.Template;
import com.casper.staffing.repository.TemplateRepository;
import com.casper.staffing.service.TemplateService;
import com.casper.staffing.util.CommonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.casper.staffing.constants.CommonConstants.DIRECTION_ASC;
import static com.casper.staffing.constants.CommonConstants.PAGE_1;
import static com.casper.staffing.constants.CommonConstants.PAGE_SIZE;
import static com.casper.staffing.constants.CommonConstants.SORT_BY_ID;

@Service
@Slf4j
public class TemplateServiceImpl implements TemplateService {
    private TemplateRepository templateRepository;

    public TemplateServiceImpl(final TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public List<Template> getAllTemplates() {
        log.info("getting default page size");
        return getAllTemplates(PAGE_1, PAGE_SIZE, SORT_BY_ID, DIRECTION_ASC);
    }

    @Override
    public List<Template> getAllTemplates(final int page,
                                          final int pageSize,
                                          final String sortBy,
                                          final String direction) {
        PageRequest pageRequest = CommonUtils.createPageRequest(page, pageSize, sortBy, direction);
        return templateRepository.findAll(pageRequest).getContent();
    }

    @Override
    public List<Template> getAllVisibleTemplates() {
        return templateRepository.findTemplatesByVisibleIsTrue();
    }

    @Override
    public Template getTemplateById(final String templateId) {
        final Optional<Template> template = templateRepository.findById(UUID.fromString(templateId));
        return template.orElse(null);
    }

    @Override
    public Template createOrUpdateTemplate(final Template template) {
        final Template savedTemplate = templateRepository.save(template);
        log.info("Update successful. Template ID: {}", savedTemplate.getId());

        return savedTemplate;
    }
}
