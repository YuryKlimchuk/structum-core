package com.hydroyura.structum.core.shared.event;

public interface EventPublisher {

    <T extends Event> void publish(T event);

}
