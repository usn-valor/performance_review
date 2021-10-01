package clone;

public class CloneExample {

    public static void main(String[] args) throws CloneNotSupportedException {
        Animal animal1 = new Animal("Dog", 5);
        animal1.display();
        Animal animal2 = animal1.clone();
        animal2.setName("Cat");
        animal1.display();
        animal2.display();
    }

    private static class Animal implements Cloneable{
        private String name;
        private int age;

        private Animal(String name, int age){
            this.name = name;
            this.age = age;
        }
        void setName(String name){
            this.name = name;
        }
        void setAge(int age){
            this.age = age;
        }
        void display(){
            System.out.printf("Animal %s \n", name);
        }

        public Animal clone() throws CloneNotSupportedException{
            return (Animal) super.clone();
        }
    }
}
