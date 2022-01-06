package ru.salikhov.model;

import org.hibernate.validator.constraints.Range;
import ru.salikhov.entity.SocksEntity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class Socks {

    @NotEmpty
    private String  color;

    @Range(min = 0, max = 100)
    @NotNull
    private Integer     cottonPart;

    @Min(value = 1)
    @NotNull
    private Integer     quantity;

    public static SocksEntity toEntity(Socks model) {
        return new SocksEntity(model.getColor(),
                                model.getCottonPart(),
                                    model.getQuantity());
    }

    public Socks() {
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCottonPart() {
        return cottonPart;
    }

    public void setCottonPart(int cottonPart) {
        this.cottonPart = cottonPart;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Socks{" +
                "color='" + color + '\'' +
                ", cottonPart=" + cottonPart +
                ", quantity=" + quantity +
                '}';
    }
}
