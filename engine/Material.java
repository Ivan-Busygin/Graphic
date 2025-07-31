package engine;

import coordinateSystem.Vector3;

/**
 * Represents material properties for surface shading.
 * Представляет свойства материала для затенения поверхности.
 */
public class Material {

    /** Diffuse color of the surface рассеянный цвет поверхности */
    public Vector3 diffuse;

    /** Specular color of the surface зеркальный цвет поверхности */
    public Vector3 specular;

    /** Reflectivity factor коэффициент отражения */
    public double reflectivity;

    /** 
     * Constructor with all material properties 
     * Конструктор со всеми свойствами материала
     */
    public Material(Vector3 diffuse, Vector3 specular, double reflectivity) {
        this.diffuse = diffuse;
        this.specular = specular;
        this.reflectivity = reflectivity;
    }

    /**
     * Default material
     * Материал по умолчанию
     */
    public static Material defaultMaterial() {
        return new Material(new Vector3(1, 1, 1), new Vector3(1, 1, 1), 0.0);
    }
}
