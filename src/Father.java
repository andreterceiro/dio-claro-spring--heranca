abstract public class Father {
    protected void protectedMethodOfFather() {
        System.out.println("Protected method of father");
    }
    abstract protected void abstractPublicMethodOfFather();

    public void publicMethodOfFather() {
        System.out.println("Public method of father");
    }

    private void privateMethodOfFather() {
        System.out.println("Private method of father");
    }
    public static void main(String[] args) {
        // Father father = new Father(); // Abstract
        //father.privateMethodOfFather();
    }
    
}
