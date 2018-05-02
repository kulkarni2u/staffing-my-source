package com.casper.staffing.repository;

import com.casper.staffing.model.TemplateField;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TemplateFieldRepository extends JpaRepository<TemplateField, UUID> {
}
