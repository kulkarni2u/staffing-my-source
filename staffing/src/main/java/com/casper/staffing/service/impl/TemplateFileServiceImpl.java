package com.casper.staffing.service.impl;

import com.casper.staffing.constants.CommonConstants;
import com.casper.staffing.model.TemplateFile;
import com.casper.staffing.repository.TemplateFileRepository;
import com.casper.staffing.service.TemplateFileService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.UUID;

@Service
@Slf4j
public class TemplateFileServiceImpl implements TemplateFileService {
    private TemplateFileRepository templateFileRepository;

    @Autowired
    public TemplateFileServiceImpl(final TemplateFileRepository templateFileRepository) {
        this.templateFileRepository = templateFileRepository;
    }

    @Override
    public TemplateFile addTemplateFile(final TemplateFile templateFile, final MultipartFile file) {
        // Upload File to S3, and get the path.
        String path = UUID.randomUUID().toString();
        // Add template file record, set status to 'PROCESSING' ready & active to 'false'.
        templateFile.setStatus(CommonConstants.STATUS_PROCESSING);
        templateFile.setActive(false);
        templateFile.setReady(false);
        templateFile.setPath(path);
        templateFileRepository.save(templateFile);
        // Process Template File to generate Field Mappings. QUARTZ or a Future task?

        // Generate Template File Images QUARTZ or a Future task?

        return templateFile;
    }


}
