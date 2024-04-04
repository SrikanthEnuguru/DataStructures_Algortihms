package lld;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConcurrentTaskScheduler {
    public static void main(String[] args) throws InterruptedException {
        TaskScheduler scheduler = new TaskScheduler(4);

        // Submit tasks
        for (int i = 0; i < 10; i++) {
            int taskId = i + 1;
            scheduler.schedule(() -> System.out.println("Task " + taskId + " executed by thread " + Thread.currentThread().getName()));
        }

        // Shutdown the scheduler
        scheduler.shutdown();
    }
}

/**
 * Implement a scheduler that continuously polls the task queue and assigns tasks to worker threads for execution.
 */
 class TaskScheduler {
    private final TaskQueue taskQueue;
    private final TaskExecutor taskExecutor;

    public TaskScheduler(int numThreads) {
        taskQueue = new TaskQueue();
        taskExecutor = new TaskExecutor(numThreads);
    }

    public void schedule(Task task) throws InterruptedException {
        taskQueue.enqueue(task);
        taskExecutor.execute(taskQueue.dequeue());
    }

    public void shutdown() {
        taskExecutor.shutdown();
    }
}

/**
 * Create a pool of worker threads that continuously retrieve tasks from the task queue and execute them.
 * Use an executor service to manage the pool of worker threads and handle task execution.
 */
 class TaskExecutor {
    private final ExecutorService executor;

    public TaskExecutor(int numThreads) {
        executor = Executors.newFixedThreadPool(numThreads);
    }

    public void execute(Task task) {
        executor.execute(task::run);
    }

    public void shutdown() {
        executor.shutdown();
    }
}

/**
 * Implement a thread-safe task queue to store pending tasks.
 * Use a concurrent data structure like BlockingQueue to handle synchronization
 * and allow multiple threads to enqueue and dequeue tasks safely.
 */

 class TaskQueue {
    private final BlockingQueue<Task> queue;

    public TaskQueue() {
        queue = new LinkedBlockingQueue<>();
    }

    public void enqueue(Task task) {
        queue.offer(task);
    }

    public Task dequeue() throws InterruptedException {
        return queue.take();
    }
}







