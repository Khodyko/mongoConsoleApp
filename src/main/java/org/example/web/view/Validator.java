package org.example.web.view;

import org.example.web.exception.ReaderException;

public class Validator {

    public void isStringNotNullNotVoid(String string) throws ReaderException {
        if (string == null || string.equals("")) {
            throw new ReaderException("Введенная строка пуста");
        }
    }

    public void isStringNumIsBetween(String string, Integer from, Integer to) throws ReaderException {
        try {
            int num = Integer.parseInt(string);
            if (num <= from || num >= to) {
                throw new ReaderException("Введенное число не находится в диапазоне номеров операций");
            }
        } catch (NumberFormatException e) {
            throw new ReaderException("Ввод не является числом", e);
        }
    }

}
