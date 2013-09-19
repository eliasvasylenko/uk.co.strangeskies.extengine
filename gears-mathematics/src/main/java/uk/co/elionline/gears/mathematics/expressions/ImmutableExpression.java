package uk.co.elionline.gears.mathematics.expressions;

import uk.co.elionline.gears.utilities.Observer;
import uk.co.elionline.gears.utilities.Self;

public class ImmutableExpression<T> implements Self<ImmutableExpression<T>>,
		Expression<T> {
	private final T value;

	public ImmutableExpression(T value) {
		this.value = value;
	}

	@Override
	public final ImmutableExpression<T> getThis() {
		return this;
	}

	@Override
	public final ImmutableExpression<T> copy() {
		return this;
	}

	@Override
	public final void clearObservers() {
	}

	@Override
	public final T getValue() {
		return value;
	}

	@Override
	public final boolean addObserver(Observer<? super Expression<T>> observer) {
		return false;
	}

	@Override
	public final boolean removeObserver(Observer<? super Expression<T>> observer) {
		return false;
	}
}
