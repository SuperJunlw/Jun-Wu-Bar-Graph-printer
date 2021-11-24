package Controller;

public class UpdateMessage implements Message
{
    private String redValue;
    private String greenValue;
    private String blueValue;

    public UpdateMessage(String redValue, String greenValue, String blueValue)
    {
        this.redValue = redValue;
        this.greenValue = greenValue;
        this.blueValue = blueValue;
    }

    public String getRedValue() {
        return redValue;
    }

    public String getGreenValue() {
        return greenValue;
    }

    public String getBlueValue() {
        return blueValue;
    }
}
