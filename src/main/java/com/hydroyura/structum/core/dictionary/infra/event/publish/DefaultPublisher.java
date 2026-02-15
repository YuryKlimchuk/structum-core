package com.hydroyura.structum.core.dictionary.infra.event.publish;

import com.hydroyura.structum.core.shared.event.Event;
import com.hydroyura.structum.core.shared.event.EventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DefaultPublisher implements EventPublisher {

    @Override
    public <T extends Event> void publish(T event) {
        log.info("Publishing event with type = [{}] & class = [{}]", event.eventType(), event.getClass().getSimpleName());
    }

}
