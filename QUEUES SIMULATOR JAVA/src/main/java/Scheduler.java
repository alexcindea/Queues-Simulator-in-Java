import java.util.ArrayList;
import java.util.List;

public class Scheduler {
    private List<Server> servers;
    private int maxNoServers;
    private int maxTaskPerServer;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTaskPerServer){
        servers = new ArrayList<Server>();
        for(int i = 0; i < maxNoServers; i++){
            Server aux = new Server(maxTaskPerServer);
            servers.add(aux);
            new Thread(aux).start();
        }
    }

    public void changeStrategy(SelectionPolicy policy){
        if(policy == SelectionPolicy.SHORTEST_QUEUE){
            strategy = new ConcreteStrategyQueue();
        }
        if(policy == SelectionPolicy.SHORTEST_TIME){
            strategy = new ConcreteStrategyTime();
        }
    }

    public void dispatchTask(Task t){
        strategy.addTask(servers, t);
    }

    public List<Server> getServers(){
        return servers;
    }
}
