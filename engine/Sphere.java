package engine;

import coordinateSystem.Vector3;

/**
 * Сфера в 3D пространстве.
 * A sphere in 3D space.
 */
public class Sphere {
    private final Vector3 center;
    private final double radius;

    public Sphere(Vector3 center, double radius) {
        this.center = center;
        this.radius = radius;
    }

    public Vector3 getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * Проверка пересечения луча со сферой.
     * Checks if ray intersects with this sphere.
     */
    public boolean intersects(Ray ray) {
        Vector3 oc = Vector3.subtract(ray.getOrigin(), center);

        double a = Vector3.computeDotProduct(ray.getDirection(), ray.getDirection());
        double b = 2.0 * Vector3.computeDotProduct(oc, ray.getDirection());
        double c = Vector3.computeDotProduct(oc, oc) - radius * radius;

        double discriminant = b * b - 4 * a * c;

        return discriminant >= 0;
    }
}
