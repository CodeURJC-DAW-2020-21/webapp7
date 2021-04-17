package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.Service.UserService;
import com.webapp7.webapp7.model.Course;
import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.net.URI;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/materials")
public class MaterialControllerApi {
    interface MaterialBasic extends Material.Basic {}

    @Autowired
    private com.webapp7.webapp7.Service.MaterialService materialService;

    @Autowired
    private UserService userService;

    @JsonView(MaterialBasic.class)
    @GetMapping("/")
    public ResponseEntity<Collection<Material>> getMaterials() {
        List<Material> materials = materialService.listMaterials();
        if (!materials.isEmpty()) {
            return ResponseEntity.ok(materials);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(MaterialBasic.class)
    @PostMapping("/")
    public ResponseEntity<Material> addMaterials(@RequestBody Material material, HttpServletRequest request) throws IOException {
        Principal principal = request.getUserPrincipal();
        User user = userService.findByName(principal.getName());
        Course course = user.getCourse();
        material.setCourse(course);
        materialService.save(material);
        return ResponseEntity.created(fromCurrentRequest().path("/").buildAndExpand(material.getId()).toUri()).body(material);
    }

    @JsonView(MaterialBasic.class)
    @PostMapping("/{id}/file")
    public ResponseEntity<Object> uploadFile(@PathVariable long id, @RequestParam MultipartFile multipartFile)
            throws IOException {

        Material material = materialService.findById(id).orElseThrow(null);

        if (material != null) {

            URI location = fromCurrentRequest().build().toUri();

            if (!multipartFile.isEmpty()) {
                String fileName = multipartFile.getOriginalFilename();
                material.setCourse(material.getCourse());
                material.setName(fileName);
                material.setContent(multipartFile.getBytes());
            }
            materialService.save(material);

            return ResponseEntity.created(location).build();

        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(MaterialBasic.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable long id) throws IOException {
        Material material = materialService.findById(id).orElse(null);
        if (material != null) {
            materialService.deleteMaterial(id);
            return ResponseEntity.ok(material);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(MaterialBasic.class)
    @PutMapping("/{id}")
    public ResponseEntity<Collection<Material>> UpdateMaterial(@PathVariable long id, HttpServletRequest request) {
        Material material = materialService.findById(id).orElseThrow(null);
        Principal principal = request.getUserPrincipal();
        User user = userService.findByName(principal.getName());
        if (user != null) {
            user.getFinishedMaterials().add(material);
            user.setNumberMaterial(user.getFinishedMaterials().size());
            userService.save(user);
            return ResponseEntity.ok(user.getFinishedMaterials());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @JsonView(MaterialBasic.class)
    @GetMapping("/recommendations")
    public ResponseEntity<Collection<Material>> materialRecomendations(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        User user = userService.findByName(principal.getName());
        if (user != null) {
            Course course = user.getCourse();
            List<Material> listMaterial = materialService.listMaterials();
            int index = 0;
            while (!listMaterial.isEmpty() && index < listMaterial.size()) {
                if (listMaterial.get(index).getCourse() != null && !listMaterial.get(index).getCourse().equals(course)) {
                    listMaterial.remove(index);
                } else {
                    index++;
                }
            }

            List<Material> listRecomendations = new ArrayList<>();
            List<User> listUsers = userService.findAllUsers();
            int i = 0;
            int j = 0;
            while (!listUsers.isEmpty() && i < listUsers.size()) {
                List<Material> listStudentMaterial = listUsers.get(i).getFinishedMaterials();
                while (!listStudentMaterial.isEmpty() && j < listStudentMaterial.size()) {
                    if (user.getCourse().equals(listUsers.get(i).getCourse())) {
                        if (listRecomendations.isEmpty() || !listRecomendations.contains(listStudentMaterial.get(j))) {
                            listRecomendations.add(listStudentMaterial.get(j));
                        }
                    }
                    j++;
                }
                j = 0;
                i++;
            }

            List<Material> listStudent = user.getFinishedMaterials();
            i = 0;
            j = 0;
            while (!listStudent.isEmpty() && !listRecomendations.isEmpty() && i < listStudent.size()) {
                while (!listRecomendations.isEmpty() && j < listRecomendations.size()) {
                    if (listRecomendations.get(j).equals(listStudent.get(i))) {
                        listRecomendations.remove(j);
                    } else {
                        j++;
                    }
                }
                j = 0;
                i++;
            }
            return ResponseEntity.ok(listRecomendations);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @JsonView(User.NumberMaterial.class)
    @GetMapping("/graph")
    public ResponseEntity<Collection<User>> materialGraph(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        if (principal != null) {
            User user = userService.findByName(principal.getName());
            Course course = user.getCourse();
            List<User> listUsers = userService.findAllUsers();

            int index = 0;

            while (!listUsers.isEmpty() && index < listUsers.size()) {
                if (listUsers.get(index).getCourse() == null || !listUsers.get(index).getCourse().equals(course) || !listUsers.get(index).getRol().equals("alumno")) {
                    listUsers.remove(index);
                } else {
                    index++;
                }
            }
            return ResponseEntity.ok(listUsers);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


}
