package uk.co.strangeskies.extengine.entity.components.physics;

import uk.co.strangeskies.extengine.entity.Entity;
import uk.co.strangeskies.extengine.entity.behaviour.BehaviourComponent;
import uk.co.strangeskies.extengine.entity.behaviour.BehaviourComponentBuilder;
import uk.co.strangeskies.extengine.entity.state.StateComponent;
import uk.co.strangeskies.extengine.entity.state.StateComponentBuilder;
import uk.co.strangeskies.extengine.physics.PhysicsBody;
import uk.co.strangeskies.extengine.physics.PhysicsSpace;
import uk.co.strangeskies.utilities.factory.Factory;

public class PhysicsComponents {
	private final StateComponent<PhysicsBody, Object> physicsBodyState;
	private final StateComponent<PhysicsSpace, Object> physicsSpaceState;

	private final BehaviourComponent physicsBehaviour;

	public PhysicsComponents(Factory<PhysicsSpace> physicsSpaceFactory,
			BehaviourComponentBuilder behaviourComponentBuilder,
			StateComponentBuilder stateComponentBuilder) {
		physicsBodyState = stateComponentBuilder.configure()
				.<PhysicsBody, Object> data(PhysicsBody::new)
				.name("Physics Body State")
				.description("The state of a body which can physically interact")
				.create();

		physicsSpaceState = stateComponentBuilder.configure()
				.<PhysicsSpace, Object> data(physicsSpaceFactory)
				.name("Physics Space State")
				.description("The state of a self contained physics space")
				.writeDependencies(physicsBodyState).create();

		physicsBehaviour = behaviourComponentBuilder.configure().process(p -> {
			for (Entity entity : p.participatingEntities()) {
				p.entity().state().getData(entity, getPhysicsBodyState());
			}
		}).name("Physics Behaviour").description("The behaviour of a cursor")
				.writeDependencies(physicsBodyState).create();
	}

	public final StateComponent<PhysicsBody, Object> getPhysicsBodyState() {
		return physicsBodyState;
	}

	public final StateComponent<PhysicsSpace, Object> getPhysicsSpaceState() {
		return physicsSpaceState;
	}

	public final BehaviourComponent getPhysicsBehaviour() {
		return physicsBehaviour;
	}
}
