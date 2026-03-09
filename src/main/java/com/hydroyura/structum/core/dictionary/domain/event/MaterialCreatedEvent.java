package com.hydroyura.structum.core.dictionary.domain.event;

import static com.hydroyura.structum.core.shared.event.EventType.CREATED;

public record MaterialCreatedEvent(String json) implements Event {

    @Override
    public EventType eventType() {
        return CREATED;
    }

}
