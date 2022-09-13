package ss6_inheritance.exercises.class_2D_and_3D;

import java.util.Arrays;

public class Point3D extends Point2D {
    private float z;

    public Point3D() {
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }

    public void setXYZ(float x, float y, float z) {
        super.setXY(x, y);
        setZ(z);
    }

    public float[] getXYZ() {
        return new float[]{super.getX(), super.getY(), getZ()};
    }

    @Override
    public String toString() {
//        return "Point3D{" +
//                "z=" + z +
//                ", " + super.toString() +
//                '}';
        return "(" + super.getX() + "," + super.getY() + "," + getZ() + ")";
    }
}
