package com.webapp7.webapp7.controller;

import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.model.User;
import com.webapp7.webapp7.repository.MaterialRepository;
import org.springframework.ui.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class MaterialController {

    @Autowired
    private MaterialRepository materialRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/student")
    public String viewStudentPage(Model model, HttpServletRequest request){
        String username = request.getUserPrincipal().getName();
        User user = userService.selectByEmail(username);
        Course course = user.getCourse();
        model.addAttribute("userName", username);
        List<Material> listMaterial = materialRepository.findAll();
        int index = 0;
        while (!listMaterial.isEmpty() && index < listMaterial.size()){
            if (listMaterial.get(index).getCourse()!=null && !listMaterial.get(index).getCourse().equals(course)){
                listMaterial.remove(index);
            }else{
                index++;
            }
        }

        List<Material> listRecomendations = new ArrayList<>();
        List<User> listUsers = userService.findAllUsers();
        int i = 0;
        int j = 0;
        while (!listUsers.isEmpty() && i < listUsers.size()){
            List<Material> listStudentMaterial = listUsers.get(i).getFinishedMaterials();
            while (!listStudentMaterial.isEmpty() && j < listStudentMaterial.size()) {
                if (user.getCourse().equals(listUsers.get(i).getCourse())) {
                    if (listRecomendations.isEmpty() || !listRecomendations.contains(listStudentMaterial.get(j))) {
                        listRecomendations.add(listStudentMaterial.get(j));
                    }
                }
                j ++;
            }
            j = 0;
            i++;
        }

        List<Material> listStudent = user.getFinishedMaterials();
        i = 0;
        j = 0;
        while   (!listStudent.isEmpty() && !listRecomendations.isEmpty() && i < listStudent.size()){
            while (!listRecomendations.isEmpty() && j < listRecomendations.size()){
                if (listRecomendations.get(j).equals(listStudent.get(i))){
                    listRecomendations.remove(j);
                }else {
                    j++;
                }
            }
            j = 0;
            i++;
        }

        model.addAttribute("listRecomendations", listRecomendations);
        model.addAttribute("listMaterial",listMaterial);
        return "user_student";
    }


    @GetMapping("/user_instructor")
    public String viewInstructorPage(Model model, HttpServletRequest request){
        List <User> users= userService.findAllUsers();
        model.addAttribute("users", users);





        String username = request.getUserPrincipal().getName();
        User user = userService.selectByEmail(username);
        Course course = user.getCourse();
        model.addAttribute("userName", username);
        List<Material> listMaterial = materialRepository.findAll();
        int index = 0;
        while (!listMaterial.isEmpty() && index < listMaterial.size()){
            if (listMaterial.get(index).getCourse()!=null && !listMaterial.get(index).getCourse().equals(course)){
                listMaterial.remove(index);
            }else{
                index++;
            }
        }
        List<User> listUsers = userService.findAllUsers();
        index = 0;
        while (!listUsers.isEmpty() && index < listUsers.size()){
            if (listUsers.get(index).getCourse()==null || !listUsers.get(index).getCourse().equals(course) || !listUsers.get(index).getRol().equals("alumno")){
                listUsers.remove(index);
            }else{
                index++;
            }
        }
        model.addAttribute("students_in_course",listUsers);
        model.addAttribute("course_imparted",course);
        model.addAttribute("listMaterial",listMaterial);
        return "user_instructor";
    }

    @PostMapping("/user_instructor")
    public String uploadfileInstructor(@RequestParam("material")MultipartFile multipartFile, HttpServletRequest request) throws IOException {
        String username = request.getUserPrincipal().getName();
        User user = userService.selectByEmail(username);
        Course course = user.getCourse();
        String fileName = multipartFile.getOriginalFilename();
        Material material = new Material();
        material.setCourse(course);
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
    public String CheckboxChangeValues(@PathVariable long id, HttpServletRequest request) {

        String username = request.getUserPrincipal().getName();
        User user = userService.selectByEmail(username);

        Material material = materialRepository.findById(id).orElseThrow();
        user.getFinishedMaterials().add(material);
        user.setNumberMaterial(user.getFinishedMaterials().size());
        userService.save(user);

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
