package uk.co.elionline.gears.mathematics.expressions.collections;

import uk.co.elionline.gears.mathematics.functions.IdentityFunction;

public class AssignmentBuffer<T> extends OperationApplicationBuffer<T, T> {
  public AssignmentBuffer(T front, T back) {
    super(front, back, new IdentityFunction<T>());
  }

  public AssignmentBuffer(T value) {
    super(value, new IdentityFunction<T>());
  }

  public AssignmentBuffer(DoubleBuffer<? extends T, ? extends T> doubleBuffer) {
    super(doubleBuffer.getFront(), doubleBuffer.getBack(),
        new IdentityFunction<T>());
  }
}