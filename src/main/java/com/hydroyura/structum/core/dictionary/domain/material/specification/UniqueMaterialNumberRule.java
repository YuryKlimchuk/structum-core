package com.hydroyura.structum.core.dictionary.domain.material.specification;

import com.hydroyura.structum.core.dictionary.domain.material.Material;
import com.hydroyura.structum.core.dictionary.domain.material.MaterialRepository;
import com.hydroyura.structum.core.shared.rule.Rule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueMaterialNumberRule implements Rule<Material> {

    private final MaterialRepository repository;

    @Override
    public boolean isSatisfiedBy(Material material) {
        return repository.findByNumber(material.getNumber()).isEmpty();
    }

}
