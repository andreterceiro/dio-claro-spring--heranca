public class Child extends Father{
    public void publicMethodOfChild() {
        System.out.println("Public method of child");
    }

    public void abstractPublicMethodOfFather() {
        System.out.println("Abstract public method of father");
    }

    public void publicMethodOfFather /* overrides publicMethodOfFather => não existe */() {
        System.out.println("Public method of father implementd in the Child class");
    }
}
