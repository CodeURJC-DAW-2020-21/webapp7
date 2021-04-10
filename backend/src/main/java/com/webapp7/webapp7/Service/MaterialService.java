package com.webapp7.webapp7.Service;

import com.webapp7.webapp7.model.Material;
import com.webapp7.webapp7.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    private MaterialRepository materials;

    public List<Material> listMaterials() {
        return materials.findAll();
    }

    public void save(Material material) {
        materials.save(material);
    }
}
