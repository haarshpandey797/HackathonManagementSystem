package com.nucleus.controller.bulkupload;

import com.nucleus.service.bulkuploadservices.JudgesBulkUploadService;
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
public class JudgesBilkUploadController {
    JudgesBulkUploadService judgesBulkUploadService;
    Logger logger;

    @Autowired
    public JudgesBilkUploadController(Logger logger,JudgesBulkUploadService judgesBulkUploadService){
        this.logger = logger;
        this.judgesBulkUploadService = judgesBulkUploadService;
    }
    @RequestMapping("/bulkUploadJudges")
    public String uploadController(Model model){
        model.addAttribute("uploadHeading","Upload Judges");
        return "/dashboard/judgesBulkUpload";
    }
    @RequestMapping("/handleBulkUpload")
    public String handleBulkUpload(@RequestParam("file") MultipartFile file, Model model){
        String uploadMessage;
        try {
            boolean isInserted = judgesBulkUploadService.insertJudgesFromExcel(file);
            uploadMessage = (isInserted) ? "SuccessFully Inserted" : "Some Error Occurred In Insertion";
        }catch (IOException | HibernateException | IllegalStateException | SQLException | IllegalArgumentException ie) {
            uploadMessage = "Some Error Occurred! " + ie.getMessage();
            logger.info("Error Occurred! " + ie.getMessage());
        }
        model.addAttribute("message",uploadMessage);
        model.addAttribute("uploadHeading","Upload Judges");
        return "/dashboard/judgesBulkUpload";
    }
    @ExceptionHandler({IOException.class, HibernateException.class, IllegalStateException.class, SQLException.class, DataIntegrityViolationException.class})
    public String handleException(Exception e, Model model) {
        String errorMessage;
        if (e instanceof DataIntegrityViolationException) {
            errorMessage = "A unique constraint was violated. Please ensure all Judges are unique.";
        } else {
            errorMessage = "Some Error Occurred! " + e.getMessage();
        }
        logger.error("Error Occurred! " + e.getMessage(), e);
        model.addAttribute("message", errorMessage);
        model.addAttribute("uploadHeading","Upload Judges");
        return "/dashboard/judgesBulkUpload";
    }
}
