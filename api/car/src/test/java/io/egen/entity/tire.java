package io.egen.entity;

/**
 * Created by deepakasinathan on 6/30/17.
 */
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;
import java.lang.String;

@Entity
public class tire {

    @Id
    private String id;
    private int frontLeft;
    private int frontRight;
    private int rearLeft;
    private int rearRight;
    public tire()
    {
        this.id= UUID.randomUUID().toString();
    }


    public int getFrontLeft() {
        return frontLeft;
    }

    public void setFrontLeft(int frontLeft) {
        this.frontLeft = frontLeft;
    }

    public int getFrontRight() {
        return frontRight;
    }

    public void setFrontRight(int frontRight) {
        this.frontRight = frontRight;
    }

    public int getRearLeft() {
        return rearLeft;
    }

    public void setRearLeft(int rearLeft) {
        this.rearLeft = rearLeft;
    }

    public int getRearRight() {
        return rearRight;
    }

    public void setRearRight(int rearRight) {
        this.rearRight = rearRight;
    }

    @Override
    public String toString() {
        return "Tires{" +
                "frontLeft=" + frontLeft +
                ", frontRight=" + frontRight +
                ", rearLeft=" + rearLeft +
                ", rearRight=" + rearRight +
                '}';
    }
}
