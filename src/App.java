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

        Child2 child2 = new Child2();
        Father2 father2 = new Father2();
        child2.protectedMethodOfFather2();
        father2.protectedMethodOfFather2();
        father2.protectedMethod2OfFather2();
        father2.publicMethodOfFather2();
    }
}
