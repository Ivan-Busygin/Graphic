package engine;

import coordinateSystem.Vector3;

/**
 * Луч, определяемый начальной точкой и направлением.
 * A ray defined by origin point and direction.
 */
public class Ray {
    private final Vector3 origin;
    private final Vector3 direction;

    public Ray(Vector3 origin, Vector3 direction) {
        this.origin = origin;
        this.direction = direction.normalize(); // используем normalize(), он уже есть
    }

    public Vector3 getOrigin() {
        return origin;
    }

    public Vector3 getDirection() {
        return direction;
    }

    /**
     * Возвращает точку вдоль луча на расстоянии t.
     * Returns point along the ray at distance t.
     */
    public Vector3 at(double t) {
        return Vector3.add(origin, new Vector3(
            direction.getX() * t,
            direction.getY() * t,
            direction.getZ() * t
        ));
    }
}
