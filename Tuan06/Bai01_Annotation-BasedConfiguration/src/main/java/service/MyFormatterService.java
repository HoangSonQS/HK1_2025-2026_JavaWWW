package service;

import interfaces.MyFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyFormatterService {


    @Autowired
    private MyFormatter myNumberFormatter;

    public void printFormat(double number) {
        System.out.println(myNumberFormatter.format(number));
    }
}