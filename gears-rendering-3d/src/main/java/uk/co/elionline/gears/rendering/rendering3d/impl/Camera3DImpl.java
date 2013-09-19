package uk.co.elionline.gears.rendering.rendering3d.impl;

import uk.co.elionline.gears.mathematics.expressions.Expression;
import uk.co.elionline.gears.mathematics.geometry.matrix.impl.Matrix4Impl;
import uk.co.elionline.gears.mathematics.geometry.matrix.impl.MatrixH3Impl;
import uk.co.elionline.gears.rendering.Scene;
import uk.co.elionline.gears.rendering.rendering3d.Camera3D;
import uk.co.elionline.gears.rendering.rendering3d.Data3D;

public class Camera3DImpl implements Camera3D {
	private Scene<Data3D> scene;

	private Expression<? extends MatrixH3Impl<?>> transformation;
	private Expression<? extends Matrix4Impl<?>> projection;

	@Override
	public Scene<Data3D> getScene() {
		return scene;
	}

	@Override
	public void setScene(Scene<Data3D> scene) {
		this.scene = scene;
	}

	@Override
	public Expression<? extends MatrixH3Impl<?>> getTransformation() {
		return transformation;
	}

	@Override
	public void setTransformation(Expression<? extends MatrixH3Impl<?>> transformation) {
		this.transformation = transformation;
	}

	@Override
	public Expression<? extends Matrix4Impl<?>> getProjection() {
		return projection;
	}

	@Override
	public void setProjection(Expression<? extends Matrix4Impl<?>> projection) {
		this.projection = projection;
	}
}
