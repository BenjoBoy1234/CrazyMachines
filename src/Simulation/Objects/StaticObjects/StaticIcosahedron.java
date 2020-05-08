package Simulation.Objects.StaticObjects;

import Simulation.Collisions.Boundings.BoundingPolygon;
import Simulation.Collisions.Boundings.BoundingReader;
import Simulation.RenderEngine.Core.Shaders.Core.Material;

public class StaticIcosahedron extends StaticObject{

	public StaticIcosahedron(Material material, float r, float g, float b, float x, float y) {
		super("icosahedron", material, r, g, b, x, y);
		calculateConvexeHull();
	}

	private void calculateConvexeHull() {
		BoundingPolygon[] convexeHulls = BoundingReader.read("Icosahedron", x, y);
		
		collisionContext.setBoundingPolygons(convexeHulls);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
