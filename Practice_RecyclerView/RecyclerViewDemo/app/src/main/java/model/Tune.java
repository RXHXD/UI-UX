package model;

public class Tune {
   private String TuneName;
   private int TunePic;


    public Tune(String tuneName, int tunePic) {
        TuneName = tuneName;
        TunePic = tunePic;
    }

    public String getTuneName() {
        return TuneName;
    }

    public void setTuneName(String tuneName) {
        TuneName = tuneName;
    }

    public int getTunePic() {
        return TunePic;
    }

    public void setTunePic(int tunePic) {
        TunePic = tunePic;
    }
}
