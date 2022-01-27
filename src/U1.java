public class U1 extends Rocket {
    U1() {
        this.cost = 100; // cost of U1 rocket [mil $]
        this.weight = 10000; // weight of U1 rocket [kg]
        this.maxWeight = 18000; // max weight with cargo [kg]
        this.maxCargo = this.maxWeight - this.weight; // max cargo [kg]
        this.chanceOfLaunchExplosion = 0.05;
        this.chanceOfLandingExplosion = 0.01;
    }

    public boolean launch() {
        if (Math.random() >= (this.chanceOfLaunchExplosion * ((double) this.cargo/this.maxCargo))) {
            //System.out.println("Launch successful");
            return true;
        } else {
            //System.out.println("Rocket crashed.");
            return false;
        }


    }

    public boolean land() {

        if (Math.random() >= (this.chanceOfLandingExplosion* ((double) this.cargo/this.maxCargo))) {
            //System.out.println("Landing successful");
            return true;
        } else {
            //System.out.println("Rocket crashed.");
            return false;
        }

    }
}
