package com.webapp7.webapp7.Api;

import com.fasterxml.jackson.annotation.JsonView;
import com.webapp7.webapp7.model.Material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.Collection;
import java.util.List;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

@RestController
@RequestMapping("/api/materials")
public class MaterialControllerApi {

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
        /*if (material.getImageFile() != null) {
            MultipartFile imageFile = (MultipartFile) material.getImageFile();
            material.setImageFile(BlobProxy.generateProxy(imageFile.getInputStream(), imageFile.getSize()));
        }

         */
        materialService.save(material);
        return ResponseEntity.created(fromCurrentRequest().path("/").buildAndExpand(material.getId()).toUri()).body(material);
    }

    interface MaterialBasic extends Material.Basic {
    }
}
