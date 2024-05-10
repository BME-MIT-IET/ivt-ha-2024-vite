package AsteroidMining;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Settler extends Visitor {

    private List<TeleportationGate> gates = new ArrayList<>(); /*Settler only carries two gates to deploy*/
    protected SpaceShip spaceship; /*Settler's private spaceship*/
    protected Robot robot;
    private BufferedImage img = null;
    private BufferedImage img2 = null;

    public Settler(int x, int y, Handler handler) {

        super(x, y, ID.Settler);
        spaceship = new SpaceShip();
        this.handler = handler;
        handler.addObject(spaceship);
        width = 120;
        height = 100;

        try {
            img = ImageIO.read(new File("Assets/spaceship.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void tick() {
        if(checkCollision()){

            if(!getPlace().getBounds().contains(new Point(x = x + velX*2,y = y + velY*2))){
                x = x - velX;
                y = y - velY*2;
            }


        }
        else if(!checkCollision()){
            hidden = false;
            x = x + velX;
            y = y + velY;
            this.setPlace(null);
            nexDestX = x;
            nextDestY=y;
        }

    }
    public boolean checkCollision(){
        Rectangle rec1 = this.getBounds();
        for(Place p1: handler.neighbours){
            if(rec1.intersects(p1.getBounds())){
                this.setPlace(p1);
                return true;
            }
        }
        return false;
    }

    @Override
    public void render(Graphics g) throws IOException {
        g.drawImage(img, x, y, width, height, null);
        if (this.isHidden() ){
            img2 = ImageIO.read(new File("Assets/settler.png"));
            Asteroid a1 = (Asteroid)getPlace();
            g.drawImage(img2, a1.coreX,  a1.coreY, 30, 30, null);
        }

    }

    /*Settler mining the available asteroid*/
    public boolean mine() {
        Asteroid a1 = (Asteroid) this.getPlace();
        if(a1!=null) {
            if (a1.depth <= 0 && !(a1.isHollow())) {
                if (spaceship.checkCapacity()) {
                    spaceship.addResource(a1.getResource());
                    a1.removeResource();
                    return true;

                }
            } else if (a1.depth >= 0) {
                System.out.println("Asteroid is not fully drilled!");
            } else if (a1.isHollow()) {
                System.out.println("Asteroid is hollow, does not contain any resources");
            }
        }
        return false;

    }

    public boolean buildRobot() {
        Place p = super.getPlace();
        if(p!=null) {
            System.out.println("No place detected");
            return false;
        }

        int nIron = spaceship.countResource(ID.Iron);
        System.out.println("countResource(\"iron”): nIron");
        int nCarbon = spaceship.countResource(ID.Carbon);
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(ID.Uranium);
        System.out.println("countResource(\"uranium”): nUranium");

        if (nIron >= 1 && nCarbon >= 1 && nUranium >= 1) {
            System.out.println("Building a robot");
            robot = new Robot();
            handler.addObject(robot);/*inside addObject(robot) of Handler, it calls addVisitor(robot) of Asteroid*/
            System.out.println("Robot has been created successfully!");
            p.getNeighbour().addVisitor(robot);
            System.out.println("Robots are automatically controlled by the system from now on.");
            this.spaceship.removeResource(ID.Carbon, 1);
            this.spaceship.removeResource(ID.Uranium, 1);
            this.spaceship.removeResource(ID.Iron, 1);

            return true;

        } else {
            System.out.println("You do not have enough resources!");
        }
        return false;
    }

    /*Filling the hollow asteroid with one unit of selected resource*/
    public boolean fillAsteroid() {
        Asteroid a1 = (Asteroid) this.getPlace();
        if(a1==null)return false;
        if (!a1.isFullyDrilled()) {
            return false;
        }
        if (a1.isHollow()) {
            Resource resource = null;

            /*we can select the resource */

            resource = spaceship.getResource(ID.Iron);
            if (resource != null) {
                if (spaceship.removeResource(resource)) {
                    a1.addResource(resource);
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
        return false;
    }


    /*Checking the inventory of Spaceship of settler*/
    public void checkInventory() {
        for (Resource r : spaceship.resources.keySet()) {
            System.out.println(r.getType() + "->" + spaceship.resources.get(r));
        }
    }

    /*Building the teleporation gate but if necessary resources are available*/
    public boolean buildTeleportationGates() {

        int nIron = spaceship.countResource(ID.Iron);
        System.out.println("countResource(\"iron”): nIron");
        int nWaterIce = spaceship.countResource(ID.WaterIce);
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(ID.Uranium);
        System.out.println("countResource(\"uranium”): nUranium");

        if (nIron >= 1 && nWaterIce >= 1 && nUranium >= 1) {
            System.out.println("Building a teleportation gate!");
            TeleportationGate gate1 = new TeleportationGate();
            TeleportationGate gate2 = new TeleportationGate();
            gate1.setGate(gate2);
            gate2.setGate(gate1);
            gates.add(gate1);
            System.out.println("First Gate Added- addGate()");
            gates.add(gate2);
            System.out.println("Second Gate Added- addGate()");

            this.spaceship.removeResource(ID.Uranium, 1);
            this.spaceship.removeResource(ID.Iron, 1);
            this.spaceship.removeResource(ID.WaterIce, 1);

            return true;

        } else {
            System.out.println("You do not have enough resources!");
        }
        return false;
    }

    /*Deploying the new built available gate*/
    public void deployGate() {
        Place p = super.getPlace();
        if(p!=null) {
            System.out.println("No place detected");
            return;
        }
        if (gates.size() == 2) {
            TeleportationGate gate1 = gates.get(0); // creating the gate
            this.getPlace().addNeighbour(gate1);
            gates.remove(gate1);
        } else if (gates.size() == 1) {
            this.getPlace().addNeighbour(gates.get(0));
            gates.clear();
        } else {
            System.out.println("You have no new build Teleportation Gates");
        }
    }

    public boolean buildSpaceStation() {
        int nIron = spaceship.countResource(ID.Iron);
        System.out.println("countResource(\"iron”): nIron");
        int nCarbon = spaceship.countResource(ID.Carbon);
        System.out.println("countResource(\"carbon”): nCarbon");
        int nUranium = spaceship.countResource(ID.Uranium);
        System.out.println("countResource(\"uranium”): nUranium");
        int nWaterIce = spaceship.countResource(ID.WaterIce);
        System.out.println("countResource(\"uranium”): waterIce");

        if (nIron >= 3 && nCarbon >= 3 && nUranium >= 3 && nWaterIce >= 3) {
            System.out.println("You have enough resources! Building a SpaceStation?");
            robot = new Robot();

            System.out.println("SpaceStation is built successfully!");
            this.spaceship.removeResource(ID.Carbon, 3);
            this.spaceship.removeResource(ID.Uranium, 3);
            this.spaceship.removeResource(ID.Iron, 3);
            this.spaceship.removeResource(ID.WaterIce, 3);
            return true;
        } else {
            System.out.println("You do not have enough resources!");
        }
        return false;
    }
}
