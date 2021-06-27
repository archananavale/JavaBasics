/*
Pollymorphism
runtime polymorphism : inheritance , methode overiding

complile time polymorphisam is method overloading
compile
 */

class AnimalP {
    public void animalsound(){
        System.out.println("all animal has distinct sound");
    }
}
class DogP extends AnimalP{

    public void animalsound(){
        super.animalsound();
        System.out.println("dog barks ");
    }
}
class cowP extends  AnimalP{
    public void soundofcow(){
        System.out.println("cow : mooh");
    }

}

class MethodOverloadingEx{
    public void CalculateArea(int r){
        System.out.println("area : "+(3.14*r*r));
    }
    public void CalculateArea(int l,int b){
        System.out.println("area :"+(l*b));
    }
}


public class PollymorphisamEx {
    public static void main(String[] args) {
       //run time polymorphisam : which class method to call decided at run time
        DogP obj1= new DogP();
        obj1.animalsound();
        cowP obj2= new cowP();
        obj2.animalsound();
        obj2.soundofcow();

        //compile time pollymorphisam:
        MethodOverloadingEx obj3= new MethodOverloadingEx();
        obj3.CalculateArea(2);
        obj3.CalculateArea(2,4);
    }


}
