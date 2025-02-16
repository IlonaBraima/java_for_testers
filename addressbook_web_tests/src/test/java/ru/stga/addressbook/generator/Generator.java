package ru.stga.addressbook.generator;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

public class Generator {

    @Parameter(names={"--type", "-t"})
    String type;

    @Parameter(names={"--output", "-o"})
    String output;

    @Parameter(names={"--format", "-f"})
    String format;

    @Parameter(names={"--count", "-n"})
    int count;


    public static void main(String[] args) {
        var generator = new Generator();
        JCommander.newBuilder()
            .addObject(generator)
            .build()
            .parse(args);
        generator.run();
    }

    private void run() {
        var data = generate();
        save(data);
    }

    private Object generate() {
        return null;
    }

    private void save(Object data) {
    }

}
