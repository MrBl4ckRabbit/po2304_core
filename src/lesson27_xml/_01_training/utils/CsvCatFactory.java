package lesson27_xml._01_training.utils;

import lesson27_xml._01_training.exceptions.TxtException;
import lesson27_xml._01_training.model.CSVCat;
import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;

public class CsvCatFactory {
    public static CSVCat getInstance(String catsString) throws TxtException {
        var lexemes = catsString.split(",");
        try {
            validateStringLength(lexemes.length);
            validateIsNumber(lexemes[0], lexemes[2]);
            validateNameByEmpty(lexemes[1]);
            var name = lexemes[1];
            var id = validateIdOrAgeByNegative(Integer.parseInt(lexemes[0]));
            var age = validateIdOrAgeByNegative(Integer.parseInt(lexemes[2]));
            return new CSVCat(id, name, age);
        } catch (IllegalStateException e) {
            throw new TxtException(catsString, e);
        }
    }

    private static void validateStringLength(int length) {
        if (length != 3) {
            throw new IllegalStateException("Wrong line format!");
        }
    }

    private static void validateIsNumber(String... lexemes) {
        try {
            Arrays.stream(lexemes).forEach(Integer::parseInt);
        } catch (NumberFormatException e) {
            throw new IllegalStateException("Id or Age are not Integer");
        }
    }

    private static void validateNameByEmpty(String name) {
        if (StringUtils.isEmpty(name)) {
            throw new IllegalStateException("Name is empty!");
        }

    }

    private static int validateIdOrAgeByNegative(int value) {
        if (value < 0) {
            throw new IllegalStateException("Wrong Id or age!");
        } else {
            return value;
        }
    }
}
