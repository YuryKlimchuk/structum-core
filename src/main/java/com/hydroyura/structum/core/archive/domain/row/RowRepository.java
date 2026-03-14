package com.hydroyura.structum.core.archive.domain.row;

import java.util.Optional;

public interface RowRepository {

    Row save(Row row);

    Optional<Row> find(Row.RowId id);

}
