public class App {
    public static void main(String[] args) throws Exception {
        Child child = new Child();
        child.protectedMethodOfFather();
        child.abstractPublicMethodOfFather();
        child.publicMethodOfFather();
        child.publicMethodOfChild();

        Father childAsFather = new Child(); 
        childAsFather.publicMethodOfFather();
        // Não posso fazer isto pois na declaração indiquei que o tipo é Father e não Child
        //childAsFather.publicMethodOfChild();

    }
}
