package engine;

import coordinateSystem.Vector3;

/**
 * Represents a point light source in 3D space.
 * Представляет точечный источник света в 3D пространстве.
 */
public class Light {

    /** Light position позиция света */
    public Vector3 position;

    /** Light color/intensity цвет/интенсивность света */
    public Vector3 color;

    /**
     * Constructor for a light source.
     * Конструктор источника света.
     */
    public Light(Vector3 position, Vector3 color) {
        this.position = position;
        this.color = color;
    }
}
