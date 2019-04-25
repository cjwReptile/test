package design.test1;

/**
 * @Auther: cjw
 * @Date: 2018/9/29 13:59
 * @Description:
 */
public class DisplayManager extends AbstractDisplay{

    private AbstractDisplay display;

    @Override
    public void display() {
           display.display();
    }

    public AbstractDisplay getDisplay() {
        return display;
    }

    public void setDisplay(AbstractDisplay display) {
        this.display = display;
    }
}
