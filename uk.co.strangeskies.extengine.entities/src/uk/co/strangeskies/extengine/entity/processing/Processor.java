package uk.co.strangeskies.extengine.entity.processing;

import java.util.Collection;

import uk.co.strangeskies.extengine.entity.management.EntityManager;
import uk.co.strangeskies.extengine.entity.scheduling.Scheduler;

public interface Processor {
	public abstract boolean startProcessing(EntityManager entityManager);

	public abstract boolean startProcessing(EntityManager entityManager,
			Collection<Scheduler> processors);

	public abstract boolean stopProcessing();
}