package Advanced.Classes.E07Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private Company company;
    private List<Pokemon> pokemons;
    private List<Parents> parents;
    private List<Children> children;
    private Car car;

    public Person() {
        this.pokemons = new ArrayList<>();
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setPokemon(Pokemon pokemon) {
        if (!checkIfPokemonExists(pokemons, pokemon)) {
            this.pokemons.add(pokemon);
        }
    }

    private boolean checkIfPokemonExists(List<Pokemon> pokemons, Pokemon pokemon) {
        for (int i = 0; i < pokemons.size(); i++) {
            if (pokemons.get(i).getName().equals(pokemon.getName())) {
                return true;
            }
        }
        return false;
    }

    public void setParents(Parents parent) {
        if (!checkIfParentExists(parents, parent)) {
            this.parents.add(parent);
        }
    }

    private boolean checkIfParentExists(List<Parents> parents, Parents parent) {
        for (int i = 0; i < parents.size(); i++) {
            if (parents.get(i).getName().equals(parent.getName())) {
                return true;
            }
        }
        return false;
    }

    public void setChildren(Children child) {
        if (!checkIfChildExists(children, child)) {
            this.children.add(child);
        }
    }

    private boolean checkIfChildExists(List<Children> children, Children child) {
        for (int i = 0; i < children.size(); i++) {
            if (children.get(i).getName().equals(child.getName())) {
                return true;
            }
        }
        return false;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append("Company:");
        strBuild.append(System.lineSeparator());
        if (company != null) {
            strBuild.append(company.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Car:");
        strBuild.append(System.lineSeparator());
        if (car != null) {
            strBuild.append(car.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Pokemon:");
        strBuild.append(System.lineSeparator());
        for (Pokemon pokemon : pokemons) {
            strBuild.append(pokemon.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Parents:");
        strBuild.append(System.lineSeparator());
        for (Parents parent : parents) {
            strBuild.append(parent.toString());
            strBuild.append(System.lineSeparator());
        }
        strBuild.append("Children:");
        strBuild.append(System.lineSeparator());
        for (Children child : children) {
            strBuild.append(child.toString());
            strBuild.append(System.lineSeparator());
        }
        return strBuild.toString();
    }
}
