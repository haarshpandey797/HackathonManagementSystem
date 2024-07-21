package com.nucleus.controller.bulkupload;

import com.nucleus.service.bulkuploadservices.ProblemStatementsBulkUploadService;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
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
public class ProblemStatementBulkUploadController {
    private ProblemStatementsBulkUploadService problemStatementsBulkUploadService;
    private Logger logger;

    public ProblemStatementBulkUploadController(ProblemStatementsBulkUploadService problemStatementsBulkUploadService,Logger logger){
        this.problemStatementsBulkUploadService = problemStatementsBulkUploadService;
        this.logger = logger;
    }
    @RequestMapping("/bulkUploadProblems")
    public String uploadController(Model model){
        model.addAttribute("uploadHeading","Upload Problems");
        return "/dashboard/problemsBulkUpload";
    }

    @RequestMapping("/handleBulkUploadProblems")
    public String handleBulkUpload(@RequestParam("file") MultipartFile file, Model model){
        String uploadMessage;
        if(file == null) {
            uploadMessage = "Insert a file to upload";
        }else {
            try {
                boolean isInserted = problemStatementsBulkUploadService.insertProblemsFromExcel(file);
                uploadMessage = (isInserted) ? "SuccessFully Inserted" : "Some Error Occurred In Insertion";
            } catch (IOException | HibernateException | IllegalStateException | IllegalArgumentException | SQLException | NullPointerException ie) {
                uploadMessage = "Some Error Occurred! " + ie.getMessage();
                logger.info("Error Occurred! " + ie.getMessage());
            }
        }
        model.addAttribute("message",uploadMessage);
        model.addAttribute("uploadHeading","Upload Problem Statements");
        return "/dashboard/problemsBulkUpload";
    }
    @ExceptionHandler({IOException.class, HibernateException.class, IllegalStateException.class, SQLException.class, DataIntegrityViolationException.class})
    public String handleException(Exception e, Model model) {
        String errorMessage;
        if (e instanceof DataIntegrityViolationException) {
            errorMessage = "A unique constraint was violated. Please ensure all Problem Statements are unique.";
        } else {
            errorMessage = "Some Error Occurred! " + e.getMessage();
        }
        logger.error("Error Occurred! " + e.getMessage(), e);
        model.addAttribute("message", errorMessage);
        model.addAttribute("uploadHeading","Upload Problem Statement");
        return "/dashboard/problemsBulkUpload";
    }
}