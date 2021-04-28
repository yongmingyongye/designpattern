package com.fx.responsibility.l_builder.a;

class Computer {
    private String cpu;
    private String gpu;
    private String memory;
    private String hd;
    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getGpu() {
        return gpu;
    }

    public void setGpu(String gpu) {
        this.gpu = gpu;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public String getHd() {
        return hd;
    }

    public void setHd(String hd) {
        this.hd = hd;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", gpu='" + gpu + '\'' +
                ", memory='" + memory + '\'' +
                ", hd='" + hd + '\'' +
                '}';
    }
}

interface ComputerBuilder {
    void setCpu();
    void setGpu();
    void seMemery();
    void setHd();
    Computer build();
}

// 建造者类，关联电脑产品
class AdvancedComputerBuilder implements ComputerBuilder {
    private Computer computer = new Computer();
    @Override
    public void setCpu() {
        computer.setCpu("i7 9700K");
    }
    @Override
    public void setGpu() {
        computer.setGpu("GTX3090");
    }
    @Override
    public void seMemery() {
        computer.setMemory("32G");
    }
    @Override
    public void setHd() {
        computer.setHd("500G固态+2T机械");
    }
    public Computer build() {
        return computer;
    }
}
// 指挥者
class Director {
    public Computer build(ComputerBuilder cb) {
        cb.setCpu();
        cb.setGpu();
        cb.seMemery();
        cb.setHd();
        return cb.build();
    }
}

public class Test {
    public static void main(String[] args) {
        AdvancedComputerBuilder acb = new AdvancedComputerBuilder();
        Director director = new Director();
        Computer computer = director.build(acb);
        System.out.println(computer);
    }
}
