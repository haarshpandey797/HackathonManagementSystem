package com.nucleus.utility;

import java.beans.PropertyEditorSupport;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateEditor extends PropertyEditorSupport {

    private DateTimeFormatter formatter;

    public DateEditor() {
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public void setAsText(String value) throws IllegalArgumentException {
        if (value == null || value.trim().isEmpty()) {
            setValue(null);
        } else {
            try {
                LocalDate date = LocalDate.parse(value, formatter);
                setValue(date);
            } catch (Exception e) {
                throw new IllegalArgumentException("Invalid date format. Please use yyyy-MM-dd.");
            }
        }
    }

    @Override
    public String getAsText() {
        String s = "";
        if (getValue() != null) {
            LocalDate date = (LocalDate) getValue();
            s = date.format(formatter);
        }
        return s;
    }
}
