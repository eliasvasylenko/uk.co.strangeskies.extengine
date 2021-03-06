package uk.co.strangeskies.extengine.entity.processing.impl;

import java.util.Set;

import uk.co.strangeskies.extengine.entity.Entity;
import uk.co.strangeskies.extengine.entity.management.EntityBehaviourManager;
import uk.co.strangeskies.extengine.entity.management.EntityManager;
import uk.co.strangeskies.extengine.entity.management.EntityStateManager;
import uk.co.strangeskies.extengine.entity.state.StateComponent;
import uk.co.strangeskies.utilities.flowcontrol.StripedReadWriteLockRelease;

public class EntityManagerProcessingWrapper implements EntityManager {
	private final EntityManager component;
	private final StripedReadWriteLockRelease<StateComponent<?, ?>> locks;

	public EntityManagerProcessingWrapper(EntityManager entityManager,
			StripedReadWriteLockRelease<StateComponent<?, ?>> locks) {
		component = entityManager;

		this.locks = locks;
	}

	protected EntityManager getComponent() {
		return component;
	}

	@Override
	public Entity create() {
		return getComponent().create();
	}

	@Override
	public EntityStateManager state() {
		return new EntityStateManagerProcessingWrapper(getComponent().state(), locks);
	}

	@Override
	public EntityBehaviourManager behaviour() {
		return getComponent().behaviour();
	}

	@Override
	public Set<Entity> getAll() {
		return getComponent().getAll();
	}

	@Override
	public boolean exists(Entity identifier) {
		return getComponent().exists(identifier);
	}

	@Override
	public boolean destroy(Entity entity) {
		return getComponent().destroy(entity);
	}
}
