package test_sth.test_java_work.colorable_mvc.service;

import test_sth.test_java_work.colorable_mvc.model.Circle;
import test_sth.test_java_work.colorable_mvc.model.Geometry;
import test_sth.test_java_work.colorable_mvc.model.Rectangle;
import test_sth.test_java_work.colorable_mvc.model.Square;

public interface IGeometryService {
    int getArea(Geometry geometry);

    default String colorAble() {
        return "Fully fill";
    }

    static int haha() {
        return 1;
    }

}
