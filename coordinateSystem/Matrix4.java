package coordinateSystem;

/**
 * Represents a 4×4 matrix for 3D transformations.
 * Представляет матрицу 4×4 для преобразований в 3D.
 */
public class Matrix4 {
    
    private double[][] values;

    /**
     * Creates an identity matrix (1 on the diagonal, 0 elsewhere).
     * Создаёт единичную матрицу (1 на диагонали, 0 в остальных ячейках).
     */
    public Matrix4() {
        values = new double[4][4];
        for (int i = 0; i < 4; i++) {
            values[i][i] = 1.0;
        }
    }

    /**
     * Creates a matrix from a 4×4 array. Throws if array is not 4×4.
     * Создаёт матрицу из массива 4×4. Выбрасывает исключение, если размер не 4×4.
     */
    private Matrix4(double[][] values) {
        if (values.length != 4 || values[0].length != 4) {
            throw new IllegalArgumentException("Matrix must be 4×4");
        }
        this.values = new double[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(values[i], 0, this.values[i], 0, 4);
        }
    }

    /**
     * Returns a new identity matrix.
     * Возвращает новую единичную матрицу.
     */
    public static Matrix4 identity() {
        return new Matrix4();
    }

    /**
     * Multiplies this matrix by another (this * other) and returns the result.
     * Умножает эту матрицу на другую (this * other) и возвращает результат.
     */
    public Matrix4 multiply(Matrix4 other) {
        double[][] result = new double[4][4];
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += this.values[row][k] * other.values[k][col];
                }
                result[row][col] = sum;
            }
        }
        return new Matrix4(result);
    }

    /**
     * Transforms the given point (Vector3) by this matrix (assumes w=1).
     * Преобразует точку (Vector3) этой матрицей (предполагается w=1).
     */
    public Vector3 transform(Vector3 v) {
        double x = v.getX();
        double y = v.getY();
        double z = v.getZ();
        double tx = values[0][0] * x + values[0][1] * y + values[0][2] * z + values[0][3];
        double ty = values[1][0] * x + values[1][1] * y + values[1][2] * z + values[1][3];
        double tz = values[2][0] * x + values[2][1] * y + values[2][2] * z + values[2][3];
        return new Vector3(tx, ty, tz);
    }

    /**
     * Returns a string representation for debugging.
     * Возвращает строковое представление для отладки.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int row = 0; row < 4; row++) {
            sb.append("[ ");
            for (int col = 0; col < 4; col++) {
                sb.append(String.format("%.3f", values[row][col])).append(" ");
            }
            sb.append("]\n");
        }
        return sb.toString();
    }
}
