import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SimulationManager {
    public int timeLimit;
    public int maxProcessingTime;
    public int minProcessingTime;
    public int numberOfServers;
    public int numberOfClients;
    public int minArrivalTime;
    public int maxArrivalTime;

    public SelectionPolicy selectionPolicy = SelectionPolicy.SHORTEST_TIME;

    private Scheduler scheduler;

    private ArrayList<Task> generatedTasks;

    public SimulationManager(int timeLimit, int maxProcessingTime, int minProcessingTime, int numberOfServers, int numberOfClients, SelectionPolicy selectionPolicy, Scheduler scheduler) {
        this.timeLimit = timeLimit;
        this.maxProcessingTime = maxProcessingTime;
        this.minProcessingTime = minProcessingTime;
        this.numberOfServers = numberOfServers;
        this.numberOfClients = numberOfClients;
        this.selectionPolicy = selectionPolicy;
        this.scheduler = scheduler;

    }

    private void generateNRandomTasks(){
        Random r = new Random();
        generatedTasks = new ArrayList<Task>();
        for(int i = 0; i < numberOfClients; i ++){
            int randomArrivalTime = minArrivalTime + r.nextInt(maxArrivalTime - minArrivalTime + 1);
            int randomProcessingTime = minProcessingTime + r.nextInt(maxProcessingTime - minProcessingTime + 1);
            Task t = new Task(randomArrivalTime, randomProcessingTime, i);
            generatedTasks.add(t);
        }
    }

    public void run(){
        int currentTime = 0;
        while(currentTime < timeLimit){
            

        }
    }

    public static void main(String[] args){
        SimulationManager gen = new SimulationManager();
        Thread t = new Thread(gen);
        t.start();
    }
}
