Testes simples. Observações:

- Veja que eu posso especificar um método abstrato como `protected`e implementá-lo na classe filha como `public`. Mas eu `não posso`reduzir a visibilidade definida pela classe pai, por exemplo colocar `protected` se lá foi definido o método abstrato como público;
- Se a classe tiver métodos abstratos, ela precisa ser abstrata.

Para as classes:

- App.java
```
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
```
- Father.java:
```
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
        Father father = new Father();
        father.privateMethodOfFather();
    } 
}
```
- Child.java:
```
public class Child extends Father{
    public void publicMethodOfChild() {
        System.out.println("Public method of child");
    }

    public void abstractPublicMethodOfFather() {
        System.out.println("Abstract public method of father");
    }

    public void publicMethodOfFather() {
        System.out.println("Public method of father implementd in the Child class");
    }
}
```

A execução com `javac App.java` e posteriormente com `java App` gera a saída:
```
Protected method of father
Abstract public method of father
Public method of father implementd in the Child class
Public method of child
Public method of father implementd in the Child class
```