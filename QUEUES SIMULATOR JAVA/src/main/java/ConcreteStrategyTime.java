import java.util.List;

public class ConcreteStrategyTime implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
        Server min = servers.get(0);
        for(Server server : servers){
            if(min.getWaitingPeriod().intValue() > server.getWaitingPeriod().intValue())
                min = server;
        }
        min.addTask(t);
    }
}
