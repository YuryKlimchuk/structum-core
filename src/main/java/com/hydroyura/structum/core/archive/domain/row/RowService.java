package com.hydroyura.structum.core.archive.domain.row;

import com.hydroyura.structum.core.archive.domain.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.jmolecules.ddd.annotation.Service;

@Service
@RequiredArgsConstructor
public class RowService {

    private final RowFactory factory;
    private final RowRepository repository;
    private final RowEventPublisher publisher;
    private final ItemService itemService;

    public Row create(String rootNumber, String childNumber, Integer count) {
        var row = factory.create(
                itemService.getAssembly(rootNumber).getId(),
                itemService.getAnyItem(childNumber).getId(),
                count
        );
        var savedRow = repository.save(row);
        publisher.publish(new Object());
        return savedRow;
    }


}
