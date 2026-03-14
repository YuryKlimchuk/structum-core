package com.hydroyura.structum.core.archive.domain.item;

import org.jmolecules.event.annotation.DomainEventPublisher;

public interface ItemEventPublisher {

    @DomainEventPublisher
    void publish(Object event);

}
