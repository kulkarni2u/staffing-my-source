package com.casper.staffing.model;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.Map;

@Data
@NoArgsConstructor
@Entity
@Table(name = "template_fields")
@EqualsAndHashCode(callSuper = true, of = {"fieldType", "name"})
public class TemplateField extends BaseEntity {
    @Column(name = "name", nullable = false)
    @NotNull
    private String name;

    @Column(name = "field_type")
    @NotNull private FieldType fieldType;

    @Column(name = "left")
    private Double left;

    @Column(name = "top")
    private Double top;

    @Column(name = "width")
    private Double width;

    @Column(name = "height")
    private Double height;

    @Column(name = "page")
    private Integer page;

    @Column(name = "is_required", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean required;

    @Column(name = "is_multiline", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean multiline;

    @Column(name = "is_readonly", columnDefinition = "BOOLEAN DEFAULT FALSE")
    private Boolean readOnly;

    @Column(name = "options", columnDefinition = "jsonb")
    @Type(value = JsonType.class)
    private Map<String, String> options;
}
