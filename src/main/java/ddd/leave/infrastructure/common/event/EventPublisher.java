package ddd.leave.infrastructure.common.event;

import ddd.leave.domain.leave.event.LeaveEvent;
import org.springframework.stereotype.Component;

@Component
public class EventPublisher {

    public void publish(LeaveEvent event) {
        //send to MQ
        //mq.send(event);
    }

}
