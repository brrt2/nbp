package pl.dashboard.nbp.validation;

/**
 * Supplies a method allowing to validate a date argument passed as String.
 *
 * @author Bartosz Pieczara
 */
public interface DateValidator {

    boolean isDateValid(String date);
}
