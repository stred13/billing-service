package com.lut.billingservice.controller;

import com.lut.billingservice.dto.CloudProjectDTO;
import com.lut.billingservice.dto.OrganizationDTO;
import com.lut.billingservice.model.CloudProject;
import com.lut.billingservice.service.CloudProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class CloudProjectController {
    @Autowired
    private CloudProjectService cloudProjectService;

    /**
     * Onboards a new cloud project by accepting a CloudProjectDTO in the request body.
     *
     * @param cloudProjectDTO the DTO containing cloud project data
     * @return the saved CloudProject entity
     */
    @PostMapping("/create-cloud-project")
    public CloudProject createCloudProject(@RequestBody CloudProjectDTO cloudProjectDTO) {
        return cloudProjectService.onboandCloudProject(cloudProjectDTO);
    }

    /**
     * Retrieves a cloud project by its ID.
     *
     * @param id the ID of the cloud project to be retrieved
     * @return the CloudProject entity
     */
    @GetMapping("/get-cloud-project/{id}")
    public CloudProject getCloudProjectById(@PathVariable String id) {
        return cloudProjectService.getCloudProjectById(UUID.fromString(id));
    }

    /**
     * Deletes a cloud project by its ID.
     *
     * @param id the ID of the cloud project to be deleted
     */
    @GetMapping("/delete-cloud-project/{id}")
    public void deleteCloudProjectById(@PathVariable String id) {
        cloudProjectService.deleteCloudProjectById(UUID.fromString(id));
    }

    /**
     * Retrieves all cloud projects.
     *
     * @return an iterable of all CloudProject entities
     */
    @GetMapping("/get-all-cloud-projects")
    public Iterable<CloudProject> getAllCloudProjects() {
        return cloudProjectService.getAllCloudProjects();
    }

    /**
     * Updates an existing cloud project by its ID using the provided CloudProjectDTO.
     *
     * @param id               the ID of the cloud project to be updated
     * @param cloudProjectDTO the DTO containing updated cloud project data
     * @return the updated CloudProject entity
     */
    @PutMapping("/update-cloud-project/{id}")
    public CloudProject updateCloudProject(@PathVariable String id, @RequestBody CloudProjectDTO cloudProjectDTO) {
        return cloudProjectService.updateCloudProject(UUID.fromString(id), cloudProjectDTO);
    }

    /**
     * Creates a new organization using the provided OrganizationDTO.
     *
     * @param organizationDTO the DTO containing organization data
     * @return the created organization object
     */
    @GetMapping("/get-org-by-id/{id}")
    public Object getOrganizationById(@PathVariable String id) {
        return cloudProjectService.getOrganizationById(UUID.fromString(id));
    }

    /**
     * Updates an existing organization by its ID using the provided OrganizationDTO.
     *
     * @param id               the ID of the organization to be updated
     * @param organizationDTO the DTO containing updated organization data
     * @return the updated organization object
     */
    @PutMapping("/update-org-by-id/{id}")
    public Object updateOrganizationById(@PathVariable String id, @RequestBody OrganizationDTO organizationDTO) {
        return cloudProjectService.updateOrganization(UUID.fromString(id), organizationDTO);
    }

    /**
     * Deletes an organization by its ID.
     *
     * @param id the ID of the organization to be deleted
     */
    @DeleteMapping("/delete-org-by-id/{id}")
    public void deleteOrganizationById(@PathVariable String id) {
        cloudProjectService.deleteOrganizationById(UUID.fromString(id));
    }


}
