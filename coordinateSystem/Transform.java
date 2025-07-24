package coordinateSystem;

/**
 * Represents a 3D transformation including translation, rotation, and scale.
 * Представляет 3D-преобразование, включающее позицию, поворот и масштаб.
 */
public class Transform {

    private Vector3 position;
    private Vector3 rotation; // Rotation in degrees — Поворот в градусах
    private Vector3 scale;

    /**
     * Constructs a new Transform with default values.
     * Создаёт новый объект Transform с начальными значениями.
     */
    public Transform() {
        this.position = new Vector3(0, 0, 0);
        this.rotation = new Vector3(0, 0, 0);
        this.scale = new Vector3(1, 1, 1);
    }

    /**
     * Returns the position vector.
     * Возвращает вектор позиции.
     */
    public Vector3 getPosition() {
        return position;
    }

    /**
     * Sets the position vector.
     * Устанавливает вектор позиции.
     */
    public void setPosition(Vector3 position) {
        this.position = position;
    }

    /**
     * Returns the rotation vector (in degrees).
     * Возвращает вектор поворота (в градусах).
     */
    public Vector3 getRotation() {
        return rotation;
    }

    /**
     * Sets the rotation vector (in degrees).
     * Устанавливает вектор поворота (в градусах).
     */
    public void setRotation(Vector3 rotation) {
        this.rotation = rotation;
    }

    /**
     * Returns the scale vector.
     * Возвращает вектор масштаба.
     */
    public Vector3 getScale() {
        return scale;
    }

    /**
     * Sets the scale vector.
     * Устанавливает вектор масштаба.
     */
    public void setScale(Vector3 scale) {
        this.scale = scale;
    }

    /**
     * Builds the combined transformation matrix from position, rotation, and scale.
     * Строит итоговую матрицу преобразования на основе позиции, поворота и масштаба.
     */
    public Matrix4 getTransformationMatrix() {
        Matrix4 translationMatrix = Matrix4.createTranslation(position);
        Matrix4 rotationMatrix = Matrix4.createRotation(rotation); // Градусы!
        Matrix4 scaleMatrix = Matrix4.createScale(scale);

        return translationMatrix.multiply(rotationMatrix).multiply(scaleMatrix);
    }

    /**
     * Applies the full transform to a 3D point and returns the result.
     * Применяет полное преобразование к точке и возвращает результат.
     */
    public Vector3 applyTo(Vector3 point) {
        return getTransformationMatrix().multiply(point);
    }

    /**
     * Returns the inverse transformation matrix (for example, for camera view).
     * Возвращает обратную матрицу преобразования (например, для камеры).
     */
    public Matrix4 getInverseTransformationMatrix() {
        Matrix4 scaleInv = Matrix4.createScale(new Vector3(
            1.0 / scale.getX(), 1.0 / scale.getY(), 1.0 / scale.getZ()
        ));

        Matrix4 rotationInv = Matrix4.createRotation(Vector3.negate(rotation));
        Matrix4 translationInv = Matrix4.createTranslation(Vector3.negate(position));

        return scaleInv.multiply(rotationInv).multiply(translationInv);
    }

}