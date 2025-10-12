package interfaces.Impl;

import interfaces.MyFormatter;
import org.springframework.stereotype.Component;

@Component
public class MyNumberFormatter implements MyFormatter {
    @Override
    public String format(double number) {
        return "Number format: " + number;
    }
}