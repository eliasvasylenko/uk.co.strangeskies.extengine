package uk.co.strangeskies.gears.physics;

import uk.co.strangeskies.gears.utilities.Copyable;

public class PhysicsBody implements Copyable<PhysicsBody> {
	@Override
	public PhysicsBody copy() {
		return new PhysicsBody();
	}
}