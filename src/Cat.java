import java.util.Objects;
import java.util.Random;

public class Cat implements Function {
    private String name;
    private Integer age;
    private Integer satietyState;
    private Integer delightState;
    private Integer healthState;
    private boolean functionState;
    private Integer averageState;

    public Cat(String name, int age, int satietyState, int delightState, int healthState) {
        this.name = name;
        this.age = age;
        this.satietyState = satietyState;
        this.delightState = delightState;
        this.healthState = healthState;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cat cat = (Cat) o;
        return age == cat.age && satietyState == cat.satietyState && delightState == cat.delightState && healthState == cat.healthState && functionState == cat.functionState && Objects.equals(name, cat.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, satietyState, delightState, healthState, functionState);
    }

    public int getAverageState() {
        this.averageState = (this.healthState + this.satietyState + this.delightState) / 3;
        return this.averageState;
    }

    public void setAverageState(Integer averageState) {
        this.averageState = averageState;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSatietyState() {
        return satietyState;
    }

    public void setSatietyState(int fedState) {
        this.satietyState = fedState;
    }

    public int getDelightState() {
        return delightState;
    }

    public void setDelightState(int delightState) {
        this.delightState = delightState;
    }

    public int getHealthState() {
        return healthState;
    }

    public void setHealthState(int healthState) {
        this.healthState = healthState;
    }

    public boolean isFunctionState() {
        return functionState;
    }

    public void setFunctionState(boolean functionState) {
        this.functionState = functionState;
    }

    public int countAverage(Cat cat){
        int average = 0;
        average = (cat.getSatietyState()+cat.getHealthState()+cat.getDelightState())/3;
        return average;
    }

    @Override
    public Cat feedCat(Cat cat) {
        Random r = new Random();
        int random = r.nextInt(6) +1;
        if(random <= 3) {
            if (cat.getAge() < 6) {
                cat.setSatietyState(cat.getSatietyState() + 7);
                cat.setDelightState(cat.getDelightState()+7);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setSatietyState(cat.getSatietyState() + 5);
                cat.setDelightState(cat.getDelightState()+5);
            } else {
                cat.setSatietyState(cat.getSatietyState() + 4);
                cat.setDelightState(cat.getDelightState()+4);
            }
            System.out.printf("You've fed a %s, %d years old\n", cat.getName(), cat.getAge());
        }else {
            if (cat.getAge() < 6) {
                cat.setSatietyState(cat.getSatietyState() + 7);
                cat.setDelightState(cat.getDelightState()-1);
                cat.setHealthState(cat.getHealthState()-1);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setSatietyState(cat.getSatietyState() + 5);
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-2);
            } else {
                cat.setSatietyState(cat.getSatietyState() + 4);
                cat.setDelightState(cat.getDelightState()-3);
                cat.setHealthState(cat.getHealthState()-3);
            }
            System.out.printf("%s was poisoned",cat.getName());
        }
        return cat;
    }

    @Override
    public Cat playWithCat(Cat cat) {
        Random r = new Random();
        int random = r.nextInt(6) +1;
        if(random <= 3){
            if(cat.getAge() < 6){
                cat.setDelightState(cat.getDelightState()+7);
                cat.setHealthState(cat.getHealthState()+7);
                cat.setSatietyState(cat.getSatietyState()-3);
            }else if(cat.getAge() >= 6 && cat.getAge() < 10){
                cat.setDelightState(cat.getDelightState()+5);
                cat.setHealthState(cat.getHealthState()+5);
                cat.setSatietyState(cat.getSatietyState()-5);
            }else{
                cat.setDelightState(cat.getDelightState()+4);
                cat.setHealthState(cat.getHealthState()+4);
                cat.setSatietyState(cat.getSatietyState()-6);
            }
            System.out.printf("You've played with %s, %d years old\n", cat.getName(), cat.getAge());
        }else{
            if(cat.getAge() < 6){
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-2);
                cat.setSatietyState(cat.getSatietyState()-4);
            }else if(cat.getAge() >= 6 && cat.getAge() < 10){
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-3);
                cat.setSatietyState(cat.getSatietyState()-6);
            }else{
                cat.setDelightState(cat.getDelightState()-2);
                cat.setHealthState(cat.getHealthState()-4);
                cat.setSatietyState(cat.getSatietyState()-7);
            }
            System.out.printf("You accidentally hurt %s",cat.getName());
        }
        return cat;
    }

    @Override
    public Cat cureCat(Cat cat) {
        Random r = new Random();
        int random = r.nextInt(6) +1;
        if(random <= 3) {
            if (cat.getAge() < 6) {
                cat.setHealthState(cat.getHealthState() + 7);
                cat.setDelightState(cat.getDelightState() - 3);
                cat.setSatietyState(cat.getSatietyState() - 3);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setHealthState(cat.getHealthState() + 5);
                cat.setDelightState(cat.getDelightState() - 5);
                cat.setSatietyState(cat.getSatietyState() - 5);
            } else {
                cat.setHealthState(cat.getHealthState() + 4);
                cat.setDelightState(cat.getDelightState() - 6);
                cat.setSatietyState(cat.getSatietyState() - 6);
            }
            System.out.printf("You've taken care of %s, %d years old\n",cat.getName(),cat.getAge());
        }else {
            if (cat.getAge() < 6) {
                cat.setHealthState(cat.getHealthState() - 2);
                cat.setDelightState(cat.getDelightState() - 4);
                cat.setSatietyState(cat.getSatietyState() - 4);
            } else if (cat.getAge() >= 6 && cat.getAge() < 10) {
                cat.setHealthState(cat.getHealthState() - 2);
                cat.setDelightState(cat.getDelightState() - 6);
                cat.setSatietyState(cat.getSatietyState() - 6);
            } else {
                cat.setHealthState(cat.getHealthState() - 2);
                cat.setDelightState(cat.getDelightState() - 6);
                cat.setSatietyState(cat.getSatietyState() - 6);
            }
            System.out.printf("Doctor has given wrong pills to %s accidentally",cat.getName());
        }
        return cat;
    }

    @Override
    public String toString() {
        return String.format(" | %8s | %4d | %6d | %4d | %7d | %12d |",
                name, age, satietyState, delightState, healthState, getAverageState());
    }
}