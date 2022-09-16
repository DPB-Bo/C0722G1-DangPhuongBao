package test_sth.test_java_work.colorable_mvc.service;

import test_sth.test_java_work.colorable_mvc.model.Circle;
import test_sth.test_java_work.colorable_mvc.model.Geometry;

public class CircleService implements IGeometryService {

    @Override
    public int getArea(Geometry circle) {
        return (int) (Math.pow(((Circle) circle).getRadius(), 2) * Math.PI);
    }
}
