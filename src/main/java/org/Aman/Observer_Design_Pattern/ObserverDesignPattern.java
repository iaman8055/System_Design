package org.Aman.Observer_Design_Pattern;


import java.util.ArrayList;
import java.util.List;

interface ISubscriber{
    void update();
}

interface IChannel{
    void subscribe(ISubscriber subscriber);
    void unsubscribe(ISubscriber subscriber);
    void notifySubscriber();
}

class Channel implements IChannel{

    List<ISubscriber>subscribers;
    private String name;
    private String latestVideo;
    public Channel(String name){
        this.name=name;
        this.subscribers = new ArrayList<>();
    }
    @Override
    public void subscribe(ISubscriber subscriber) {
        if(!subscribers.contains(subscriber)){
            subscribers.add(subscriber);
        }
    }

    @Override
    public void unsubscribe(ISubscriber subscriber) {
            subscribers.remove(subscriber);

    }


    @Override
    public void notifySubscriber() {
        for(ISubscriber sub:subscribers){
            sub.update();
        }
    }
    public void uploadVideo(String title){
        latestVideo=title;
        System.out.println("\n[" + name + " uploaded \"" + title + "\"]");
        notifySubscriber();
    }
    public String getVideoData(){
        return "\nCheckout our new Video : " + latestVideo + "\n";

    }
}
class Subscriber implements ISubscriber{
    private String name;
    private Channel channel;


    public Subscriber(String name, Channel channel) {
        this.name = name;
        this.channel = channel;
    }
    @Override
    public void update() {
        System.out.println("Hey " + name + "," + channel.getVideoData());

    }
}
public class ObserverDesignPattern {

    public void main(String[] args){
        Channel channel=new Channel("coderArmy");
        Subscriber sub1=new Subscriber("Aman",channel);
        Subscriber sub2=new Subscriber("Arjun",channel);

        channel.subscribe(sub1);
        channel.subscribe(sub2);
        channel.uploadVideo("Observer design pattern");
        channel.unsubscribe(sub2);
    }
}
