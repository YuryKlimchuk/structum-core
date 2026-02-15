package com.hydroyura.structum.core.dictionary.domain.material;

import java.util.Optional;

public interface MaterialRepository {

    Optional<Material> findByNumber(String number);
    Material save(Material material);

}
