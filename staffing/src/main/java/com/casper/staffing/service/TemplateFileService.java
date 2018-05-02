package com.casper.staffing.service;

import com.casper.staffing.model.TemplateFile;
import org.springframework.web.multipart.MultipartFile;

public interface TemplateFileService {
    TemplateFile addTemplateFile(TemplateFile templateFile, MultipartFile file);

}
