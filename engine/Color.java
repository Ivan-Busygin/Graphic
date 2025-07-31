package engine;
/**
 * Представление цвета в формате RGB.
 * Representation of color in RGB format.
 * Значения каждого компонента от 0.0 до 1.0
 * The values of each component range from 0.0 to 1.0
 */
public class Color {
    public float r; // Red   / Красный Red
    public float g; // Green / Зелёный Green
    public float b; // Blue  / Синий Blue

    /**
     * Конструктор по значениям RGB
     * RGB Value Constructor
     */
    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Цвет по умолчанию — чёрный
     * The default color is black
     */
    public Color() {
        this(0.0f, 0.0f, 0.0f);
    }

    /**
     * Сложение цветов для освещения
     * Adding colors for lighting
     */
    public Color add(Color other) {
        return new Color(this.r + other.r, this.g + other.g, this.b + other.b);
    }

    /**
     * Умножение цвета на коэффициент яркость света, отражение и т.д.
     * Multiplying the color by the coefficient of light brightness, reflection, etc.
     */
    public Color multiply(float factor) {
        return new Color(this.r * factor, this.g * factor, this.b * factor);
    }

    /**
     * Преобразование в целое число RGB для вывода в изображение
     * Convert to RGB integer for output to image
     */
    public int toRGB() {
        int red   = Math.min(255, Math.max(0, (int)(r * 255)));
        int green = Math.min(255, Math.max(0, (int)(g * 255)));
        int blue  = Math.min(255, Math.max(0, (int)(b * 255)));
        return (red << 16) | (green << 8) | blue;
    }
}
