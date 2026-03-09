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

    public static final List<Material> storage = new ArrayList<>();


    @Override
    public Optional<Material> findByNumber(String number) {
        return storage.stream().filter(m -> number.equals(m.getNumber())).findFirst();
    }

    @Override
    public Material save(Material material) {
        var nextId = storage
                .stream()
                .map(Material::getId)
                .map(MaterialId::id)
                .max(Long::compareTo)
                .orElse(0L);
        var newMaterial = Material.create(material, nextId + 1L);
        storage.add(newMaterial);
        return newMaterial;
    }
}
