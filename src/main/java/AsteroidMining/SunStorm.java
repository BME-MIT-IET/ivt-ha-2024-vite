package AsteroidMining;

import java.awt.*;

public class SunStorm extends GameObject {
    private int time;

    public SunStorm(int x, int y, int time) {

        super(x, y, ID.SunStorm);
        this.time =time;
    }


    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

    }
    /*Checking the Collison*/
    public void collisionWith(Asteroid a1){
        for(Visitor visitor: a1.getVisitors()){
            if(visitor!=null && !visitor.isHidden()){
                if(visitor.getId().equals(ID.Settler)){
                    visitor.die();
                    System.out.println("Settler has been killed by the Sunstorm ");
                }
                if(visitor.getId().equals(ID.Robot)){
                    Robot r1 = (Robot) visitor;
                    r1.getDamage(5);
                    System.out.println("Robot has been damaged by the Sunstorm");
                    if(r1.getHealth()<=0){
                        visitor.die();
                    }
                }
            }
        }

    }
}
