package uk.co.elionline.gears.mathematics.logic;

import uk.co.elionline.gears.mathematics.expressions.BinaryOperationExpression;
import uk.co.elionline.gears.mathematics.expressions.Expression;

public class XNOR<O extends XNORable<?, ? super T>, T>
		extends
		BinaryOperationExpression</*@ReadOnly*/O, /*@ReadOnly*/XNORable<? extends O, ? super T>, /*@ReadOnly*/T> {
	public XNOR(
			Expression<? extends /*@ReadOnly*/XNORable<? extends O, ? super T>> firstOperand,
			Expression<? extends /*@ReadOnly*/T> secondOperand) {
		super(firstOperand, secondOperand, new XNOROperation<O, T>());
	}
}
