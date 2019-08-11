package org.acme.spring.web;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

import org.acme.spring.web.License;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import io.quarkus.panache.common.Parameters;

@ApplicationScoped
public class LicenseRepository implements PanacheRepositoryBase<License, String>  {
    public List<License> findByOrganizationId(String organizationId) {
        return find("organizationId", organizationId).list();
    }

    public License findByOrganizationIdAndLicenseId(String organizationId, String licenseId) {
        License license = License.find("organizationId = :organizationId and licenseId = :licenseId",
         Parameters.with("organizationId", organizationId).and("licenseId", licenseId)).firstResult();

         return license;
    }

    @Transactional
    public void save(License license) {
        license.persist();;
    }

    @Transactional
    public void update(License license){
        if (! license.isPersistent()) license.persist();;
    }

    @Transactional
    public void  delete(License license) {
        if (! license.isPersistent()) {
            license = License.findById(license.licenseId);
        }
        license.delete();
    }
}