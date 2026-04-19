package org.Aman.Decorator_Design_Pattern;

interface Character{
    String  getabilities();
}

class Mario implements Character{

    @Override
    public String getabilities() {
        return "Mario";
    }
}

abstract class CharacterDecorator implements Character{
    protected Character character;
    public CharacterDecorator(Character c){
        this.character=c;
    }

}

class HeightUp extends CharacterDecorator{

    public HeightUp(Character c){
        super(c);
    }
    @Override
    public String getabilities() {
        return character.getabilities()+"with heightUp";
    }


}
class GunPowerUp extends CharacterDecorator{
    public GunPowerUp(Character c){
        super(c);
    }

    @Override
    public String getabilities() {
        return character.getabilities()+"with gun";
    }
}
class StarPowerUp extends CharacterDecorator {
    public StarPowerUp(Character c) {
        super(c);
    }



    @Override
    public String getabilities() {
        return character.getabilities()+ " with Star Power (Limited Time)";
    }
}

public class DecoratorPattern {
    public static void main(String[] args) {
        Character mario =new Mario();
        System.out.println("Basic Character: " + mario.getabilities());
        mario=new HeightUp(mario);
        System.out.println("After HeightUp: " + mario.getabilities());
        mario=new GunPowerUp(mario);
        System.out.println("After GunPowerUp: " + mario.getabilities());
        mario=new HeightUp(new GunPowerUp(new StarPowerUp(mario)));
        System.out.println("All power: " + mario.getabilities());

    }

}
