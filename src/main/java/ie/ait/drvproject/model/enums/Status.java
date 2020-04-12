package ie.ait.drvproject.model.enums;

/**
 * Created by Pelumi.Oyefeso on 12-04-2020
 */
public enum Status {

    PREMIUM (2),
    BASIC (1),
    SUSPENDED (0);

    String name;
    Status(int i) {
        this.name = String.valueOf(i);
    }
}
