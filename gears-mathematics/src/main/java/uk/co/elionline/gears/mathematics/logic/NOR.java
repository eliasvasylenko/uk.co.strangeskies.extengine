package uk.co.elionline.gears.mathematics.logic;

import uk.co.elionline.gears.mathematics.expressions.BinaryOperationExpression;
import uk.co.elionline.gears.mathematics.expressions.Expression;

public class NOR<O extends NORable<?, ? super T>, T>
		extends
		BinaryOperationExpression</*@ReadOnly*/O, /*@ReadOnly*/NORable<? extends O, ? super T>, /*@ReadOnly*/T> {
	public NOR(
			Expression<? extends /*@ReadOnly*/NORable<? extends O, ? super T>> firstOperand,
			Expression<? extends /*@ReadOnly*/T> secondOperand) {
		super(firstOperand, secondOperand, new NOROperation<O, T>());
	}
}
