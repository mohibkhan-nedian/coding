package com.Concurrency;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallCenter {

    private final ExecutorService executorService;

    private final Queue<Call> calls;

    private final int numOfAgents;
    private boolean open = true;

    public CallCenter(int numOfAgents) {
        executorService = Executors.newFixedThreadPool(numOfAgents);
        calls = new ArrayBlockingQueue<>(numOfAgents);
        this.numOfAgents = numOfAgents;
    }

    public void open(){
        for(int i = 0; i < numOfAgents; i++){
            Thread agent = new Thread(new Agent(i, calls));
            executorService.execute(agent);
            //agent.start();

        }
        open=true;
    }

    public void accept(Call call) {
        if (open) {
            calls.add(call);
        }
    }
    public void close(){
        System.out.println("############ Closing");
        for(int i = 0; i < numOfAgents; ++i) {
            accept(Agent.GO_HOME);
        }

        executorService.shutdown();
        open = false;
    }

    public static class Call {
        private final int id;
        private final int duration;
        private final long startTime;

        public Call(int id, int duration) {
            this.id = id;
            this.duration = duration;
            this.startTime = System.currentTimeMillis();;
        }

        public void answer()  {
            try {

                System.out.println(" answering call with call id "+id);
                Thread.sleep(10);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    static class Agent implements Runnable{
        private Queue<Call> calls;
        private int id;
        private static final Call GO_HOME = new Call(-1,0);

        public Agent(int id, Queue<Call> c){
            this.id = id;
            calls = c;
        }
        @Override
        public void run() {
            while(true){
                Call call = calls.poll();

                if(call == GO_HOME){
                    System.out.println("stop answering call "+id);
                    break;
                }
                System.out.println("answering call "+id + " call =" + call);
                if(call!=null) call.answer();

            }
        }
    }
}

