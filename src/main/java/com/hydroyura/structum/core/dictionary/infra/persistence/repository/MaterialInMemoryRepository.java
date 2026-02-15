package com.hydroyura.structum.core.dictionary.infra.persistence.repository;

import com.hydroyura.structum.core.dictionary.domain.material.Material;
import com.hydroyura.structum.core.dictionary.domain.material.MaterialRepository;
import com.hydroyura.structum.core.dictionary.domain.shared.MaterialId;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
//@ConditionalOnMissingBean(value = MaterialRepository.class)
public class MaterialInMemoryRepository implements MaterialRepository {

    public static final List<Material> materials = new ArrayList<>();


    @Override
    public Optional<Material> findByNumber(String number) {
        return materials.stream().filter(m -> number.equals(m.getNumber())).findFirst();
    }

    @Override
    public Material save(Material material) {
        var nextId = materials
                .stream()
                .map(Material::getId)
                .map(MaterialId::id)
                .max(Long::compareTo)
                .orElse(1L);
        var newMaterial = Material.create(material, nextId);
        materials.add(newMaterial);
        return newMaterial;
    }
}
