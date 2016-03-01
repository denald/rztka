package rozetka.locators;

import org.openqa.selenium.By;
import rozetka.locators.interfaces.ILocator;


public enum PersonalPageLocators implements ILocator {

    SIGN_OUT_LINK(
            "Sign out link",
            LocatorsType.BY_ID,
            "profile_signout"
    );

    private String name;
    private LocatorsType locatorsType;
    private String rawLocator;
    private By byLocator;

    PersonalPageLocators(final String name, final LocatorsType locatorsType, final String rawLocator){
        this.name = name;
        this.locatorsType = locatorsType;
        this.rawLocator = rawLocator;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public By getBy() {
        this.byLocator = this.locatorsType.getBy(this.rawLocator);
        return this.byLocator;
    }
}
