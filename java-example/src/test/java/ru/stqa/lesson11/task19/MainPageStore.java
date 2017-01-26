package ru.stqa.lesson11.task19;

/**
 * Created by Maria on 1/26/2017.
 */
public class MainPageStore {

    private String locatorProductMainPage,  locatorHomeButton,locatorCheckoutLink;


    public static MainPageStore.Builder newEntity() {
        return new MainPageStore().new Builder();
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
        public MainPageStore.Builder withProductMainPage(String locatorProductMainPage) { MainPageStore.this.locatorProductMainPage = locatorProductMainPage; return this; }
        public MainPageStore.Builder withHomeButton(String locatorHomeButton) { MainPageStore.this.locatorHomeButton = locatorHomeButton; return this; }
        public MainPageStore.Builder withCheckoutLink(String locatorCheckoutLink) { MainPageStore.this.locatorCheckoutLink = locatorCheckoutLink; return this; }
    }


}
