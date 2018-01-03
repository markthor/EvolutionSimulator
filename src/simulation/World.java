package simulation;

import java.util.List;

public class World {
    private List<Organism> organisms;

    public List<Organism> getOrganisms() {
        return organisms;
    }
    
    public void addOrganism(Organism organism) {
        organisms.add(organism);
    }
}
