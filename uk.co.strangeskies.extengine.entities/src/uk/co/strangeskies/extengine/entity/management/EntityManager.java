package uk.co.strangeskies.extengine.entity.management;

import java.util.Set;

import uk.co.strangeskies.extengine.entity.Entity;
import uk.co.strangeskies.utilities.factory.Factory;

/**
 * Naming convention suggests 'entity' for instances of {@link EntityManager},
 * as it is semantically consistent with the state() and behaviour() methods in
 * that it is a description of the domain of operations provided.
 *
 * @author Elias N Vasylenko
 *
 */
public interface EntityManager extends Factory<Entity> {
	public boolean exists(Entity identifier);

	public Set<Entity> getAll();

	/**
	 * Remove an entity from this managers management.
	 *
	 * @param entity
	 *          The identity of the Entity we want to remove.
	 * @return True if the entity was removed, false otherwise.
	 */
	public boolean destroy(Entity entity);

	public EntityStateManager state();

	public EntityBehaviourManager behaviour();
}
