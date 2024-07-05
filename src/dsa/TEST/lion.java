package dsa.TEST;

public class lion implements animal {

    @Override
    public void sleep() {
        System.out.println("yes it sleep");
    }

    @Override
    public void eat(String s) {
        System.out.println(s);
    }

    @Override
    public void hunt() {
        System.out.println("its hunt");
    }
}
