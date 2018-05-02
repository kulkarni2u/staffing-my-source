package com.casper.staffing.repository;

import com.casper.staffing.model.Template;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TemplateRepository extends JpaRepository<Template, UUID> {
    List<Template> findTemplatesByVisibleIsTrue();
}
