package com.hydroyura.structum.core.dictionary.domain.material;

import com.hydroyura.structum.core.dictionary.domain.shared.MaterialId;
import com.hydroyura.structum.core.dictionary.domain.shared.Standard;
import com.hydroyura.structum.core.dictionary.domain.shared.StandardType;
import lombok.*;

import java.util.Objects;

@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Getter
public class Material {

    private final MaterialId id;
    private Standard standard;
    private MaterialType type;
    private String name;
    private String number;


    public static Material create(Long id,
                                  String standardName,
                                  String standardNumber,
                                  StandardType standardType,
                                  MaterialType type,
                                  String name,
                                  String number) {
        return new Material(
                Objects.isNull(id) ? null : new MaterialId(id),
                new Standard(standardName, standardNumber, standardType),
                type,
                name,
                number
        );
    }

    public static Material createWithoutId(String standardName,
                                           String standardNumber,
                                           StandardType standardType,
                                           MaterialType type,
                                           String name,
                                           String number) {
        return create(null, standardName, standardNumber, standardType, type, name, number);
    }

    public static Material create(Material material, Long id) {
        return create(
                id,
                material.getStandard().name(),
                material.getStandard().number(),
                material.getStandard().type(),
                material.getType(),
                material.getName(),
                material.getNumber()
        );
    }

}
