package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.repository.MaterialRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class MaterialController {
    @Autowired
    private MaterialRepository materialRepository;

    @GetMapping("/student")
    public String viewStudentPage(Model model){
        List<Material> listMaterial = materialRepository.findAll();
        model.addAttribute("listMaterial",listMaterial);
        return "user_student";
    }
    @GetMapping("/user_instructor")
    public String viewInstructorPage(Model model){
        List<Material> listMaterial = materialRepository.findAll();
        model.addAttribute("listMaterial",listMaterial);
        return "user_instructor";
    }
    @PostMapping("/admin")
    public String uploadfileAdmin(@RequestParam("material")MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        Material material = new Material();
        material.setName(fileName);
        material.setContent(multipartFile.getBytes());
        materialRepository.save(material);
        return "redirect:/admin";
    }
    @PostMapping("/user_instructor")
    public String uploadfileInstructor(@RequestParam("material")MultipartFile multipartFile) throws IOException {
        String fileName = multipartFile.getOriginalFilename();
        Material material = new Material();
        material.setName(fileName);
        material.setContent(multipartFile.getBytes());
        materialRepository.save(material);
        return "redirect:/user_instructor";
    }

    @GetMapping("/download/{id}")
    public void downloadImageAdmin(@PathVariable long id,HttpServletResponse response) throws IOException {
        Optional<Material> result = materialRepository.findById(id);
        if (result.isPresent() && result.get().getContent() != null) {
            Material material = result.get();
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename=" + material.getName();
            response.setHeader(headerKey, headerValue);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(material.getContent());
            outputStream.close();
        }
    }

    @GetMapping("/checkbox/{id}")
    public String CheckboxChangeValues(@PathVariable long id) {
        Material material = materialRepository.findById(id).orElseThrow();
        material.setChecked(true);
        materialRepository.save(material);
        return "redirect:/student";
    }

    @GetMapping("/delete/{id}")
    public String deleteMaterialInstructor(Model model, @PathVariable long id) throws IOException {
        Material material = materialRepository.findById(id).orElseThrow();
        materialRepository.deleteById(id);
        return "redirect:/user_instructor";
    }
    @GetMapping("/delete/admin/{id}")
    public String deleteMaterialAdmin(Model model, @PathVariable long id) throws IOException {
        Material material = materialRepository.findById(id).orElseThrow();
        materialRepository.deleteById(id);
        return "redirect:/admin";
    }
}
