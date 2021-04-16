package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/materials")
public class MaterialControllerApi {

    interface MaterialBasic extends Material.Basic {}

    @Autowired
    private com.webapp7.webapp7.Service.MaterialService materialService;

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
    public ResponseEntity<Material> addMaterials(@RequestBody Material material) throws IOException {
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

    @JsonView(AdminUserControllerApi.UserBasic.class)
    @DeleteMapping("/{id}")
    public ResponseEntity<Material> deleteMaterial(@PathVariable long id) throws IOException{
        Material material = materialService.findById(id).orElse(null);
        if (material!=null){
            materialService.deleteMaterial(id);
            return ResponseEntity.ok(material);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
