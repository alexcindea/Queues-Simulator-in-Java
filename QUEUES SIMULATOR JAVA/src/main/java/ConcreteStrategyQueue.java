import java.util.List;

public class ConcreteStrategyQueue implements Strategy{
    @Override
    public void addTask(List<Server> servers, Task t) {
        Server min = servers.get(0);
        for(Server server : servers){
            if(min.getTasks().length > server.getTasks().length)
                min = server;
        }
        min.addTask(t);
    }
}
