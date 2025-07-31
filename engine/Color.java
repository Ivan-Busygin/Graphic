package engine;
/**
 * Представление цвета в формате RGB.
 * Значения каждого компонента от 0.0 до 1.0
 */
public class Color {
    public float r; // Red   / Красный
    public float g; // Green / Зелёный
    public float b; // Blue  / Синий

    /**
     * Конструктор по значениям RGB
     */
    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
    }

    /**
     * Цвет по умолчанию — чёрный
     */
    public Color() {
        this(0.0f, 0.0f, 0.0f);
    }

    /**
     * Сложение цветов для освещения
     */
    public Color add(Color other) {
        return new Color(this.r + other.r, this.g + other.g, this.b + other.b);
    }

    /**
     * Умножение цвета на коэффициент яркость света, отражение и т.д.
     */
    public Color multiply(float factor) {
        return new Color(this.r * factor, this.g * factor, this.b * factor);
    }

    /**
     * Преобразование в целое число RGB для вывода в изображение
     */
    public int toRGB() {
        int red   = Math.min(255, Math.max(0, (int)(r * 255)));
        int green = Math.min(255, Math.max(0, (int)(g * 255)));
        int blue  = Math.min(255, Math.max(0, (int)(b * 255)));
        return (red << 16) | (green << 8) | blue;
    }
}
