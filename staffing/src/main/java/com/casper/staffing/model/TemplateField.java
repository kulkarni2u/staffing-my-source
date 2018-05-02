package com.casper.staffing.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.Map;
import java.util.UUID;

@Data
@NoArgsConstructor
@Entity
@Table(name = "template_fields")
@EqualsAndHashCode(callSuper = false, of = {"id", "fieldType", "name"})
public class TemplateField extends BaseEntity {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Column(name = "name", nullable = false)
    @NotNull private String name;

    @Column(name = "field_type")
    @Enumerated(EnumType.STRING)
    @Type(type = "pgsql_enum")
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
    @Type(type = "jsonb")
    private Map<String, String> options;
}
