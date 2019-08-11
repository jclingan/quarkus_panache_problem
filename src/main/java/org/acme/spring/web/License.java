package org.acme.spring.web;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

@Entity
@Table(name = "licenses")
public class License extends PanacheEntityBase {
    @Id
    @Column(name = "license_id", nullable = false)
    public String licenseId;

    @Column(name = "organization_id", nullable = false)
    public String organizationId;

    @Column(name = "product_name", nullable = false)
    public String productName;

    @Column(name = "license_type", nullable = false)
    public String licenseType;

    @Column(name = "license_max", nullable = false)
    public Integer licenseMax;

    @Column(name = "license_allocated", nullable = false)
    public Integer licenseAllocated;

    @Column(name = "comment")
    public String comment;
}