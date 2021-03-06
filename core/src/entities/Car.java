package entities;

import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * This class represents all the cars controlled by computer
 * @author Paolo Pierantozzi
 */
public class Car extends AbstractCar
{

    public Car(Stage stage,String name,float x,float y)
    {
        super(stage,name,x,y);
    }
    @Override
    public void act(float delta)
    {
        this.moveBy(0,this.getSpeed());
    }
}

