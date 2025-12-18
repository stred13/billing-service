package com.lut.billingservice.service;

import com.lut.billingservice.dto.CloudProjectDTO;
import com.lut.billingservice.dto.OrganizationDTO;
import com.lut.billingservice.model.CloudProject;
import com.lut.billingservice.model.Organization;
import com.lut.billingservice.repository.CloudProjectRepository;
import com.lut.billingservice.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class CloudProjectService {

    @Autowired
    private CloudProjectRepository cloudProjectRepository;
    @Autowired
    private OrganizationRepository organizationRepository;

    /**
     * Onboard a new CloudProject along with its Organizations
     *
     * @param cloudProjectDTO CloudProjectDTO object
     * @return Saved CloudProject object
     */
    public CloudProject onboandCloudProject(CloudProjectDTO cloudProjectDTO) {
        return cloudProjectRepository.save(this.convertDTOtoCloudProject(cloudProjectDTO));
    }

    public CloudProject getCloudProjectById(UUID id) {
        return cloudProjectRepository.findById(id).orElse(null);
    }

    public List<CloudProject> getAllCloudProjects() {
        return cloudProjectRepository.findAll();
    }

    public void deleteCloudProjectById(UUID id) {
        cloudProjectRepository.deleteById(id);
    }

    public CloudProject updateCloudProject(UUID id, CloudProjectDTO cloudProjectDTO) {
        CloudProject existingCloudProject = cloudProjectRepository.findById(id).orElseThrow(() -> new RuntimeException("Cloud project not found"));
        existingCloudProject.setCloudProjectName(cloudProjectDTO.getCloudProjectName());
        existingCloudProject.setCostCenter(cloudProjectDTO.getCostCenter());
        existingCloudProject.setOwner(cloudProjectDTO.getOwner());
        existingCloudProject.setCreatedTime(cloudProjectDTO.getCreatedTime());
        existingCloudProject.setDeletedTime(cloudProjectDTO.getDeletedTime());
        existingCloudProject.setStatus(cloudProjectDTO.getStatus());
        return cloudProjectRepository.save(existingCloudProject);
    }

    public Organization getOrganizationById(UUID id) {
        return organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
    }

    public void deleteOrganizationById(UUID id) {
        organizationRepository.deleteById(id);
    }

    public Organization updateOrganization(UUID id, OrganizationDTO organizationDTO) {
        Organization existingOrganization = organizationRepository.findById(id).orElseThrow(() -> new RuntimeException("Organization not found"));
        existingOrganization.setOrgName(organizationDTO.getOrgName());
        existingOrganization.setCreatedTime(organizationDTO.getCreatedTime());
        existingOrganization.setDeletedTime(organizationDTO.getDeletedTime());
        existingOrganization.setStatus(organizationDTO.getStatus());
        existingOrganization.setPlacement(organizationDTO.getPlacement());
        return organizationRepository.save(existingOrganization);
    }

    private CloudProject convertDTOtoCloudProject(CloudProjectDTO cloudProjectDTO) {
        CloudProject cloudProject = CloudProject.builder()
                .cloudProjectName(cloudProjectDTO.getCloudProjectName())
                .costCenter(cloudProjectDTO.getCostCenter())
                .owner(cloudProjectDTO.getOwner())
                .createdTime(cloudProjectDTO.getCreatedTime())
                .deletedTime(cloudProjectDTO.getDeletedTime())
                .status(cloudProjectDTO.getStatus())
                .organizations(new ArrayList<>())
                .build();
        cloudProjectDTO.getOrganizations().forEach(organizationDTO -> {
            Organization organization = Organization.builder()
                    .orgName(organizationDTO.getOrgName())
                    .createdTime(organizationDTO.getCreatedTime())
                    .deletedTime(organizationDTO.getDeletedTime())
                    .status(organizationDTO.getStatus())
                    .placement(organizationDTO.getPlacement())
                    .build();
            cloudProject.addOrganization(organization);
        });
        return cloudProject;
    }
}
