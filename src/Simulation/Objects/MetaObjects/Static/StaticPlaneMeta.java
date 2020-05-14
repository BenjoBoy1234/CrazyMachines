package Simulation.Objects.MetaObjects.Static;

import Simulation.Objects.MetaObjects.MetaObject;
import Simulation.Objects.StaticObjects.StaticPlane;

public class StaticPlaneMeta extends MetaObject {

    public StaticPlaneMeta (String objName, String objImageURL) {
        super(objName, objImageURL);
    }

    @Override
    public void createObject (float x, float y) {
       new StaticPlane(x, y);
    }

}
