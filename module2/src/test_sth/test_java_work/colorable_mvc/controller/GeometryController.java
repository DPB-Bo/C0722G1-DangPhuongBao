package test_sth.test_java_work.colorable_mvc.controller;

import test_sth.test_java_work.colorable_mvc.model.Circle;
import test_sth.test_java_work.colorable_mvc.model.Geometry;
import test_sth.test_java_work.colorable_mvc.model.Rectangle;
import test_sth.test_java_work.colorable_mvc.model.Square;
import test_sth.test_java_work.colorable_mvc.service.IGeometryService;
import test_sth.test_java_work.colorable_mvc.service.SquareService;

public class GeometryController {
    static Geometry[] createGeometriesList() {
        Geometry[] geometriesList = new Geometry[100];
        geometriesList[0] = new Square(5);
        geometriesList[1] = new Circle(3);
        geometriesList[2] = new Square(6);
        geometriesList[3] = new Rectangle(7, 8);
        geometriesList[4] = new Square(9);
        return geometriesList;
    }

    public void displayAreaAndColorAble() {
        Geometry[] geometriesList = createGeometriesList();

        System.out.println("Hiển thị diện tích các hình và colorable:");
        for (Geometry geometry : geometriesList) {
            if (geometry != null) {
//                System.out.printf("Diện tích của hình %s đó là: %d", geometry.getName(), IGeometryService.getArea(geometry));
                if (geometry instanceof Square) {
//                    ((SquareService)geometry).colorAble();
                }
            }
        }
    }
}
