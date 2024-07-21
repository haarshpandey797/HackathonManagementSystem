package com.nucleus.controller.bulkupload;

import com.nucleus.service.bulkuploadservices.CriteriaBulkUploadService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.sql.SQLException;

@Controller
@RequestMapping("/admin")
public class CriteriaBulkUploadController {

    private final CriteriaBulkUploadService criteriaBulkUploadService;
    private final Logger logger;

    @Autowired
    public CriteriaBulkUploadController(Logger logger, CriteriaBulkUploadService criteriaBulkUploadService) {
        this.logger = logger;
        this.criteriaBulkUploadService = criteriaBulkUploadService;
    }

    @RequestMapping("/bulkUploadCriteria")
    public String uploadController(Model model) {
        model.addAttribute("uploadHeading","Upload Criteria");
        return "/dashboard/criteria/criteriasBulkUpload";
    }


    @RequestMapping("/handleBulkUploadCriteria")
    public String handleBulkUpload(@RequestParam("file") MultipartFile file, Model model) {
        String uploadMessage;
        try {
            boolean isInserted = criteriaBulkUploadService.insertCriteriaFromExcel(file);
            uploadMessage = isInserted ? "Successfully Inserted" : "Some Error Occurred In Insertion";
        } catch (IOException | HibernateException | IllegalArgumentException | IllegalStateException | SQLException ie) {
            uploadMessage = "Some Error Occurred! " + ie.getMessage();
            ie.printStackTrace();
            logger.info("Error Occurred! " + ie.getMessage());
        }
        model.addAttribute("message", uploadMessage);
        model.addAttribute("uploadHeading","Upload Criteria");
        return "/dashboard/criteria/criteriasBulkUpload";
    }

    @ExceptionHandler({IOException.class, HibernateException.class, IllegalStateException.class, SQLException.class, DataIntegrityViolationException.class})
    public String handleException(Exception e, Model model) {
        String errorMessage;
        if (e instanceof DataIntegrityViolationException) {
            errorMessage = "A unique constraint was violated. Please ensure all criteria names are unique.";
        } else {
            errorMessage = "Some Error Occurred! " + e.getMessage();
        }
        logger.error("Error Occurred! " + e.getMessage(), e);
        model.addAttribute("message", errorMessage);
        model.addAttribute("uploadHeading","Upload Criteria");
        return "/dashboard/criteria/criteriasBulkUpload";
    }
}
