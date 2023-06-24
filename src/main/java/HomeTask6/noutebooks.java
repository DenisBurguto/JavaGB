package HomeTask6;

import java.util.Objects;

public class noutebooks {

    private String brand;
    private String model;
    private Double diagonal;
    private String processor;
    private Integer rom;
    private Integer ram;

    public noutebooks(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }


    public String getModel() {
        return model;
    }


    public Double getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Double diagonal) {
        this.diagonal = diagonal;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public Integer getRom() {
        return rom;
    }

    public void setRom(Integer rom) {
        this.rom = rom;
    }

    public Integer getRam() {
        return ram;
    }

    public void setRam(Integer ram) {
        this.ram = ram;
    }

    @Override
    public String toString() {
        return "noutebooks{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", diagonal='" + diagonal + '\'' +
                ", processor='" + processor + '\'' +
                ", rom='" + rom + '\'' +
                ", ram='" + ram + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        noutebooks that = (noutebooks) o;
        return Objects.equals(brand, that.brand)
                && Objects.equals(model, that.model)
                && Objects.equals(diagonal, that.diagonal)
                && Objects.equals(processor, that.processor)
                && Objects.equals(rom, that.rom)
                && Objects.equals(ram, that.ram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, diagonal, processor, rom, ram);
    }
}

