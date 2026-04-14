package org.Aman.Strategy_Design_Pattern;

interface WalkableRobot{
    void walk();
}
class NormalWalk implements WalkableRobot{

    @Override
    public void walk() {
        System.out.println("WALKING NORMALLY");
    }
}
class NoWalk implements WalkableRobot{

    @Override
    public void walk() {
        System.out.println("Cannot walk");
    }
}
interface FlyableRobot {
    void fly();
}
class NormalFly implements FlyableRobot{

    @Override
    public void fly() {
        System.out.println("Flying Normally");
    }
}
class NoFly implements FlyableRobot{

    @Override
    public void fly() {
        System.out.println("Cannot fly");
    }
}
interface TalkableRobot{
    void talk();
}
class NormalTalk implements TalkableRobot{

    @Override
    public void talk() {
        System.out.println("Normal Talk");
    }
}
class NoTalk implements TalkableRobot{

    @Override
    public void talk() {
        System.out.println("no talk");
    }
}
abstract class Robot {
    protected WalkableRobot walkBehaviour;
    protected TalkableRobot talkBehaviour;
    protected FlyableRobot flyBehaviour;

    public Robot(WalkableRobot w,TalkableRobot t,FlyableRobot f){
        this.flyBehaviour=f;
        this.talkBehaviour=t;
        this.walkBehaviour=w;

    }
    public void walk(){
        walkBehaviour.walk();
    }
    public void talk(){
        talkBehaviour.talk();
    }
    public void fly(){
        flyBehaviour.fly();
    }
    public abstract void projection();
}
class CompanionRobot extends Robot{
    public CompanionRobot(WalkableRobot w,TalkableRobot t,FlyableRobot f){
        super(w,t,f);
    }
    @Override
    public void projection() {

    }
}
class WorkerRobot extends Robot{
    public WorkerRobot(WalkableRobot w,TalkableRobot t,FlyableRobot f){
        super(w,t,f);
    }
    @Override
    public void projection() {
        System.out.println("Displaying worker efficiency stats...");

    }
}
public class StrategyDesignPattern {

    public void main(String[] args){
        Robot robot1=new CompanionRobot(new NormalWalk(), new NormalTalk(), new NormalFly());
        robot1.fly();
        robot1.talk();
        robot1.fly();
        robot1.projection();
        Robot robot2=new WorkerRobot(new NoWalk(),new NoTalk(),new NoFly());
        robot2.fly();
        robot2.walk();
        robot2.fly();
        robot2.projection();
    }
}
