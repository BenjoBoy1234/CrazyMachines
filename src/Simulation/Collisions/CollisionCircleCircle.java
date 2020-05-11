package Simulation.Collisions;

import Simulation.Util;
import Simulation.Objects.MovableObjects.MoveableObject;
import Simulation.Objects.StaticObjects.StaticObject;

public class CollisionCircleCircle {

/////////////////////////
////ELASTIC COLLISION////
/////////////////////////
	public static void elasticCollision(MoveableObject object1, MoveableObject object2) {	
//		float angle = (float)Math.atan2(object2.getY()-object1.getY(), object2.getX()-object1.getX());
//	
//		float m1 = object1.getMass();
//		float m2 = object2.getMass();
//		
//		Vector2f u1 = Util.rotate(object1.getVelocityX(),object1.getVelocityY(),angle);
//		Vector2f u2 = Util.rotate(object2.getVelocityX(),object2.getVelocityY(),angle);
//		
//		float v1x = (u1.x * (m1 - m2) + 2 * m2 * u2.x) / (m1+m2);
//		float v1y = (u1.y * (m1 - m2) + 2 * m2 * u2.y) / (m1+m2);
//		float v2x = (u2.x * (m2 - m1) + 2 * m1 * u1.x) / (m1+m2);
//		float v2y = (u2.y * (m2 - m1) + 2 * m1 * u1.y) / (m1+m2);
//		
//		Vector2f finalv1 = Util.rotate(v1x,v1y,-angle);
//		Vector2f finalv2 = Util.rotate(v2x,v2y,-angle);
//		
//		object1.setVelocityX(finalv1.x);
//		object1.setVelocityY(finalv1.y);
//		object2.setVelocityX(finalv2.x);
//		object2.setVelocityY(finalv2.y);	
		
		float distance = Util.getDistance(object1.getX(), object1.getY(), object2.getX(), object2.getY());
		
		float nx = (object2.getX()-object1.getX())/distance;
		float ny = (object2.getY()-object1.getY())/distance;
			
		float tx = -ny;
		float ty = nx;
			
		float dpTan1 = object1.getVelocityX()*tx + object1.getVelocityY()*ty;
		float dpTan2 = object2.getVelocityX()*tx + object2.getVelocityY()*ty;
		
		float dpNorm1 = object1.getVelocityX() * nx + object1.getVelocityY()*ny;
		float dpNorm2 = object2.getVelocityX() * nx + object2.getVelocityY()*ny;
			
		float m1 = (dpNorm1 * (object1.getMass() - object2.getMass()) + 2 * object2.getMass() *dpNorm2 ) / (object1.getMass() + object2.getMass());	
		float m2 = (dpNorm2 * (object2.getMass() - object1.getMass()) + 2 * object1.getMass() *dpNorm1 ) / (object1.getMass() + object2.getMass());
			
		object1.setVelocityX(tx * dpTan1 + nx * m1);
		object1.setVelocityY(ty * dpTan1 + ny * m1);
		object2.setVelocityX(tx * dpTan2 + nx * m2);
		object2.setVelocityY(ty * dpTan2 + ny * m2);
	}
	
	public static void elasticCollision(MoveableObject object1 , StaticObject object2) {	
		float distance = Util.getDistance(object1.getX(), object1.getY(), object2.getX(), object2.getY());
		
		float nx = (object2.getX()-object1.getX())/distance;
		float ny = (object2.getY()-object1.getY())/distance;
		
		float tx = -ny;
		float ty = nx;
		
		float dpTan1 = object1.getVelocityX()*tx + object1.getVelocityY()*ty;
		
		float dpNorm1 = object1.getVelocityX() * nx + object1.getVelocityY()*ny;
		
		float m1 = (dpNorm1 * (object1.getMass() - object2.getMass())) / (object1.getMass() + object2.getMass());
		
		object1.setVelocityX(tx*dpTan1 + nx*m1);
		object1.setVelocityY(ty*dpTan1 + ny*m1);
	}
	
	
////////////////////////
////REMOVE COLLISION////
////////////////////////	
	public static void removeCollision(MoveableObject object1, float r1, MoveableObject object2,float r2) {
		float distance = Util.getDistance(object2.getX(), object2.getY(), object1.getX(), object1.getY());
			
		float overlap = 0.5f*(distance- r1 - r2);
					
		float object1X = object1.getX()-overlap*(object1.getX()-object2.getX())/distance;
		float object1Y = object1.getY()-overlap*(object1.getY()-object2.getY())/distance;
		
		float object2X = object2.getX()+overlap*(object1.getX()-object2.getX())/distance;
		float object2Y = object2.getY()+overlap*(object1.getY()-object2.getY())/distance;
				
		object2.setX(object2X);
		object2.setY(object2Y);
		
		object1.setX(object1X);
		object1.setY(object1Y);
	}
	
	public static void removeCollision(MoveableObject object1, float r1,StaticObject object2,float r2) {
		float distance = Util.getDistance(object2.getX(), object2.getY(), object1.getX(), object1.getY());
			
		float overlap = distance- r1 -r2;
					
		float object1X = object1.getX()-overlap*(object1.getX()-object2.getX())/distance;
		float object1Y = object1.getY()-overlap*(object1.getY()-object2.getY())/distance;
			
		object1.setX(object1X);
		object1.setY(object1Y);
	}
	
}
