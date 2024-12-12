package oncall.view;

import camp.nextstep.edu.missionutils.Console;
import oncall.utils.ServiceValidation;

import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String COMMA = ",";

    public static List<String> getStringsUsingDelimiter() {
        String input = Console.readLine();
        ServiceValidation.validateNull(input);
        return Arrays.stream(input.split(COMMA))
                .map(String::trim)
                .toList();
    }

}
