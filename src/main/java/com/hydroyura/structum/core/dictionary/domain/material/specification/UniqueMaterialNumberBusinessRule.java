package com.hydroyura.structum.core.dictionary.domain.material.specification;

import com.hydroyura.structum.core.dictionary.domain.material.Material;
import com.hydroyura.structum.core.dictionary.domain.material.MaterialRepository;
import com.hydroyura.structum.core.shared.rule.BusinessRule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UniqueMaterialNumberBusinessRule implements BusinessRule<Material> {

    private final MaterialRepository repository;

    @Override
    public boolean isSatisfiedBy(Material material) {
        return repository.findByNumber(material.getNumber()).isEmpty();
    }

}
