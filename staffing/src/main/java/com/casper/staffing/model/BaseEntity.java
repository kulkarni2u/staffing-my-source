package com.casper.staffing.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;
import java.util.UUID;

//@TypeDef(name = "string-array", typeClass = StringArrayType.class)
//@TypeDef(name = "int-array", typeClass = IntArrayType.class)
//@TypeDef(name = "json", typeClass = JsonStringType.class)
//@TypeDef(name = "jsonb", typeClass = JsonBinaryType.class)
//@TypeDef(name = "jsonb-node", typeClass = JsonNodeBinaryType.class)
//@TypeDef(name = "json-node", typeClass = JsonNodeStringType.class)
//@TypeDef(name = "pgsql_enum", typeClass = PostgreSQLEnumType.class)
//@TypeDef(defaultForType = UUID.class, typeClass = UUIDBinaryType.class)

@MappedSuperclass
@Getter @Setter
class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
//    @Type(UUIDT.class)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @CreatedBy
    @Column(name = "created_by", columnDefinition = "TEXT DEFAULT 'SYSTEM'")
    private String createdBy;

    @CreatedDate
    @CreationTimestamp
    @Column(name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @UpdateTimestamp
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private String lastModifiedBy;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    @Column(name = "deleted_by")
    private String deletedBy;
}
