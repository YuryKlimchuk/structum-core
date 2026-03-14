package com.hydroyura.structum.core.archive.domain.item;

import java.util.regex.Pattern;

public interface ItemValidationContextService {

    Pattern getNumberPattern();
    Pattern getNamePattern();

}
