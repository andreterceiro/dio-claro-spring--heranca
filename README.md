# Message

To be clear. The content here is a content based on a free course. Noone can reproduce this material. If you wanna to know this material, my advice is to you access the **free** [course](https://web.dio.me/track/coding-the-future-claro-java-spring-boot). And if they end the course or start to ask money to study in the course? Well, this considerations are out of my control, but the DIO material is excelent and the course is amazing! If you acquire a DIO paln, you will have access to amazing courses.  

---

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

**Os testes evoluíram e fiz testes semelhante com PHP [neste repositório](https://github.com/andreterceiro/dio-heranca-teste-com-php).

[Tutorial](https://pt.stackoverflow.com/questions/23/qual-%C3%A9-a-diferen%C3%A7a-entre-modificadores-public-default-protected-e-private).

Em relação ao `"overrides"`,veja que não existe isto e sim um `@override`. **Existe em C# e não em Java**. A finalidade do `@override` é mostrada [aqui](https://pt.stackoverflow.com/questions/22913/qual-a-finalidade-da-override). O que entendi: como o método a ser sobrescrito **não** é abstrato, se mudar o nome de `imprime` para `imprimir` na classe pai, na classe filha não ocorreria um erro a não ser que se tenha o `@override` que obrigaria a sobrescrita de método. não confunda, em um exemplo é mostrado que o `@override` é escrito **na classe filha**.

Em relação ao `protected`, veja no teste mostrado pelo professor no vídeo da DIO, a teoria é exatamente esta que funcionou no meu teste em PHP: em uma instância eu não posso chamar um método `protected`, mas em uma filha posso. A diferença para a visibilidade default é que esta restringe ainda mais: a má e a filha precisam estar no mesmo pacote. Na visibilidade `protected` não precisa.
