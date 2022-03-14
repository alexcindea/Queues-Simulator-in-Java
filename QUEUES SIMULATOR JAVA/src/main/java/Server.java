import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{
    private BlockingQueue<Task> tasks;
    private AtomicInteger waitingPeriod;
    private AtomicInteger isRunning;


    public Server(int maxTasks){
        //initialize queue and waitingPeriod
        tasks = new LinkedBlockingQueue<>(maxTasks);
        waitingPeriod = new AtomicInteger(0);
        isRunning = new AtomicInteger(1);
    }

    public void addTask(Task newTask){
        //add task to queue
        //increment the waitingPeriod
        tasks.add(newTask);
        waitingPeriod.addAndGet(newTask.getProcessingTime());
    }

    public AtomicInteger getWaitingPeriod() {
        return waitingPeriod;
    }

    public void setWaitingPeriod(AtomicInteger waitingPeriod) {
        this.waitingPeriod = waitingPeriod;
    }

    public void run(){
        while(isRunning.get() == 1){
            //take net task from queue
            //stop the thread for a time equal with the task's processing time
            //decrement the waitingPeriod
            if(tasks.size()!= 0){
                Task t = new Task(0,0,0);
                tasks.peek();
                try {
                    Thread.sleep(t.getProcessingTime() * 1000);
                    tasks.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                waitingPeriod.set(waitingPeriod.get() - t.getProcessingTime());
            }
            if(tasks.size() == 0){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Task[] getTasks(){
        int k = 0;
        Task[] t = new Task[tasks.size()];
        for(Task task : tasks){
            t[k++] = task;
        }
        return t;
    }


}

