package com.casper.staffing.repository;

import com.casper.staffing.model.Template;
import com.casper.staffing.model.TemplateFile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateFileRepository extends JpaRepository<TemplateFile, UUID> {
    TemplateFile findTemplateFileByTemplateAndActiveIsTrue(Template template);
}
