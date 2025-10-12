package interfaces.Impl;

import interfaces.MyFormatter;
import org.springframework.stereotype.Component;

@Component
public class MyDateTimeFormatter implements MyFormatter {
    @Override
    public String format(double number) {
        return "MyDateTimeFormatter" + number;
    }
}
