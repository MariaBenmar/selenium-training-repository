package ru.stqa.lesson11.task19;

/**
 * Created by Maria on 1/26/2017.
 */
public class MainStore {

    private String locatorProductMainPage,  locatorHomeButton,locatorCheckoutLink;


    public static MainStore.Builder newEntity() {
        return new MainStore().new Builder();
    }


    public String getProductMainPage() {
        return locatorProductMainPage;
    }

    public String getHomeButton() {
        return locatorHomeButton;
    }

    public String getCheckoutLink() { return locatorCheckoutLink; }



    public class Builder {
        private Builder() {}
        public MainStore.Builder withProductMainPage(String locatorProductMainPage) { MainStore.this.locatorProductMainPage = locatorProductMainPage; return this; }
        public MainStore.Builder withHomeButton(String locatorHomeButton) { MainStore.this.locatorHomeButton = locatorHomeButton; return this; }
        public MainStore.Builder withCheckoutLink(String locatorCheckoutLink) { MainStore.this.locatorCheckoutLink = locatorCheckoutLink; return this; }
        public MainStore build() {return MainStore.this; }
    }


}
