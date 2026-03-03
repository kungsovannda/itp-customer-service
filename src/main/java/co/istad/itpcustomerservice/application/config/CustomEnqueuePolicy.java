package co.istad.itpcustomerservice.application.config;

import org.axonframework.eventhandling.EventMessage;
import org.axonframework.messaging.deadletter.DeadLetter;
import org.axonframework.messaging.deadletter.Decisions;
import org.axonframework.messaging.deadletter.EnqueueDecision;
import org.axonframework.messaging.deadletter.EnqueuePolicy;

public class CustomEnqueuePolicy implements EnqueuePolicy<EventMessage<?>> {

    private static final String RETRY_COUNT_KEY = "retries";

    private final int retryConstraint;

    public CustomEnqueuePolicy(int retryConstraint) {
        this.retryConstraint = retryConstraint;
    }

    @Override
    public EnqueueDecision<EventMessage<?>> decide(DeadLetter<? extends EventMessage<?>> letter, Throwable cause) {
        final int retries = (int) letter.diagnostics().getOrDefault("retries", -1);
        System.out.println("Retries: " + retries);
        if (retries < retryConstraint) {
            return Decisions.requeue(cause, l -> l.diagnostics().and("retries", retries + 1));
        }
        return Decisions.evict();
    }
}
