import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TaskManager {
    private List<Task> tasks;

    public TaskManager() {
        this.tasks = new ArrayList<>();
    }

    public TaskManager(String filename){
        this.tasks = loadTasksFromFile(filename);
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void listTasks(){
        if (tasks.isEmpty()){
            System.out.println("Список задач пуст.");
            return;
        }

        for (int i = 0; i < tasks.size(); i++){
            Task task = tasks.get(i);

            System.out.printf("%d. [%s] %s (до %s)%n",
                    i + 1,
                    task.isCompleted() ? "✔" : " ",
                    task.getDescription(),
                    task.getDueDate()
            );

        }
    }

    public void markTaskCompleted(int number){
        if (number < 1 || number > tasks.size()){
            System.out.println("Неверный номер задачи.");
            return;
        }
        Task task = tasks.get(number-1);
        task.markCompleted();
        System.out.println("Задача отмечена как выполненная.");
        listTasks();
    }

    public void removeTask(int number){
        if (number < 1 || number > tasks.size()){
            System.out.println("Неверный номер задачи.");
            return;
        }
        tasks.remove(number-1);
        System.out.println("Задача удалена.");
        listTasks();
    }

    public static List<Task> loadTasksFromFile(String filename){
        List<Task> tasks = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line;
            while ((line = reader.readLine()) != null){
                String[] parts = line.split(";");
                if (parts.length != 3) continue;

                String description = parts[0];
                LocalDate dueDate = LocalDate.parse(parts[1]);
                boolean isCompleted = Boolean.parseBoolean(parts[2]);

                Task task = new Task(description, dueDate, isCompleted);
                tasks.add(task);
            }
        } catch (IOException e) {
            System.out.println("Не удалось загрузить файл: " + e.getMessage());
        }
        return tasks;
    }

    public void saveTasksToFile(String filename){
        try(FileWriter writer = new FileWriter(filename)){
            for( Task task : tasks){
                String line = String.format("%s;%s;%s\n", task.getDescription(), task.getDueDate(), task.isCompleted());
                writer.write(line);
            }
            System.out.println("Задачи сохранены в файл.");
        } catch (IOException e){
            System.out.println("Ошибка при сохранении: " + e.getMessage());
        }
    }
}

