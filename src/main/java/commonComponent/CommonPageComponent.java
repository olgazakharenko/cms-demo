package commonComponent;

public class CommonPageComponent {

    private static LeftBar leftBar;

    public static LeftBar getLeftBar() {
        return leftBar;
    }

    public static void setLeftBar(LeftBar leftBar) {
        CommonPageComponent.leftBar = leftBar;
    }

}
