package Objects.MovableObjects.Collisions;

import Engine.Core.Models.LineModel;
import Engine.Primitives.CircleLine;
import Objects.Util;

public class BoundingCircle  extends Bounding{

	private float radius;

	public BoundingCircle(float x, float y,float offset,float radius) {
		super(x,y,offset);
		this.radius = radius;
		model = new LineModel(new CircleLine(radius, 30), 0, 0, 1, x,y);
	}

	/**
	 * Returns true if both balls collide
	 */
	public boolean checkCollision(BoundingCircle circle) {
		// when the radii of both circles combined is smaller than the distance between
		// both balls they collide
		return circle.getRadius() + radius > Util.getDistance(circle.getX(), circle.getY(), x, y);
	}

	public boolean checkCollision(BoundingRectangle rectangle) {
		float distanceX = (float) Math.abs(x - rectangle.getX());
		float distanceY = (float) Math.abs(y - rectangle.getY());

		if (distanceX > rectangle.getWidth() / 2 + radius)
			return false;
		if (distanceY > rectangle.getHeight() / 2 + radius)
			return false;

		if (distanceX <= rectangle.getWidth() / 2)
			return true;
		if (distanceY <= rectangle.getHeight() / 2)
			return true;

		float cornerDistance = (float) Math.pow((distanceX - rectangle.getWidth() / 2), 2)
				+ (float) Math.pow((distanceY - rectangle.getHeight() / 2), 2);

		return cornerDistance <= radius * radius;
	}

	public float getRadius() {
		return radius;
	}

	public void setRadius(float radius) {
		this.radius = radius;
	}

}