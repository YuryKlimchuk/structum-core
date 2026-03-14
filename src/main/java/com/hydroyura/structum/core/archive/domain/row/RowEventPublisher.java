package com.hydroyura.structum.core.archive.domain.row;

import org.jmolecules.event.annotation.DomainEventPublisher;

public interface RowEventPublisher {

    @DomainEventPublisher
    void publish(Object event);

}
