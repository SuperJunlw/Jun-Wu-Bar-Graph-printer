package Model;

public class Model
{
    private int redBarHeight;
    private int greenBarHeight;
    private int blueBarHeight;

    public Model()
    {
        this.redBarHeight = 0;
        this.greenBarHeight = 0;
        this.blueBarHeight = 0;
    }

    public int getGreenBarHeight() {
        return greenBarHeight;
    }
    public int getBlueBarHeight() {
        return blueBarHeight;
    }
    public int getRedBarHeight() {
        return redBarHeight;
    }
    public void setRedBarHeight(int redBarHeight) {
        this.redBarHeight = redBarHeight;
    }
    public void setGreenBarHeight(int greenBarHeight) {
        this.greenBarHeight = greenBarHeight;
    }
    public void setBlueBarHeight(int blueBarHeight) {
        this.blueBarHeight = blueBarHeight;
    }
}
