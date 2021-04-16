package com.webapp7.webapp7.Service;

import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.model.Post;
import com.webapp7.webapp7.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materials;

    public void deleteMaterial(long id) {
        materials.deleteById(id);
    }

    public List<Material> listMaterials() {
        return materials.findAll();
    }

    public void save(Material material) {
        materials.save(material);
    }

    public Optional<Material> findById(long id) {
        return materials.findById(id);
    }
}
