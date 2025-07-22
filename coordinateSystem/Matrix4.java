package coordinateSystem;

/**
 * Represents a 4x4 matrix used for 3D transformations.
 * Представляет матрицу 4x4, используемую для 3D-преобразований.
 */
public class Matrix4 {

    private final double[][] matrix;

    /** 
     * Creates a new identity matrix.
     * Создаёт новую единичную матрицу.
     */
    public Matrix4() {
        matrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            matrix[i][i] = 1.0;
        }
    }

    /** 
     * Creates a matrix with given values.
     * Создаёт матрицу с заданными значениями.
     */
    public Matrix4(double[][] values) {
        if (values.length != 4 || values[0].length != 4) {
            throw new IllegalArgumentException("Matrix must be 4x4");
        }
        matrix = new double[4][4];
        for (int i = 0; i < 4; i++) {
            System.arraycopy(values[i], 0, matrix[i], 0, 4);
        }
    }

    /**
     * Returns element at (row, col).
     * Возвращает элемент по координатам (row, col).
     */
    public double get(int row, int col) {
        validateIndices(row, col);
        return matrix[row][col];
    }

    /**
     * Sets element at (row, col) to value.
     * Устанавливает значение элемента (row, col).
     */
    public void set(int row, int col, double value) {
        validateIndices(row, col);
        matrix[row][col] = value;
    }

    /**
     * Multiplies this matrix by another matrix.
     * Умножает текущую матрицу на другую матрицу.
     */
    public Matrix4 multiply(Matrix4 other) {
        double[][] result = new double[4][4];
        double[][] a = this.matrix;
        double[][] b = other.matrix;

        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                double sum = 0.0;
                for (int k = 0; k < 4; k++) {
                    sum += a[row][k] * b[k][col];
                }
                result[row][col] = sum;
            }
        }

        return new Matrix4(result);
    }

    /**
     * Applies transformation to a vector.
     * Применяет матрицу к вектору.
     */
    public Vector3 transform(Vector3 v) {
        double[] result = applyHomogeneous(v);
        if (result[3] == 0.0) {
            throw new ArithmeticException("Invalid homogeneous coordinate (w = 0)");
        }

        return new Vector3(result[0] / result[3], result[1] / result[3], result[2] / result[3]);
    }

    /**
     * Returns a string representation of the matrix.
     * Возвращает строковое представление матрицы.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            for (double val : row) {
                sb.append(String.format("%10.4f ", val));
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Returns a copy of this matrix.
     * Возвращает копию текущей матрицы.
     */
    public Matrix4 copy() {
        return new Matrix4(this.matrix);
    }

    /**
     * Checks equality with another matrix.
     * Проверяет равенство с другой матрицей.
     */
    public boolean equals(Matrix4 other) {
        for (int row = 0; row < 4; row++) {
            for (int col = 0; col < 4; col++) {
                if (Double.compare(matrix[row][col], other.matrix[row][col]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Validates row and column indices.
     * Проверяет корректность индексов.
     */
    private void validateIndices(int row, int col) {
        if (row < 0 || row > 3 || col < 0 || col > 3) {
            throw new IndexOutOfBoundsException("Matrix indices must be in range [0..3]");
        }
    }

    /**
     * Applies matrix to a vector using homogeneous coordinates.
     * Применяет матрицу к вектору в однородных координатах.
     */
    private double[] applyHomogeneous(Vector3 v) {
        double[] result = new double[4];
        double[] input = { v.getX(), v.getY(), v.getZ(), 1.0 };

        for (int row = 0; row < 4; row++) {
            result[row] = 0;
            for (int col = 0; col < 4; col++) {
                result[row] += matrix[row][col] * input[col];
            }
        }

        return result;
    }

    /**
     * Returns identity matrix constant.
     * Возвращает единичную матрицу.
     */
    public static Matrix4 identity() {
        return new Matrix4();
    }
}