import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskManager manager = new TaskManager("tasks.txt");

        while (true){
            System.out.println("\n===== Меню =====");
            System.out.println("1. Показать задачи");
            System.out.println("2. Добавить задачу");
            System.out.println("3. Отметить задачу как выполненную");
            System.out.println("4. Удалить задачу");
            System.out.println("5. Сохранить в файл");
            System.out.println("6. Выйти");
            System.out.print("Выберите действие: ");

            String choice = scanner.nextLine();
            System.out.println();

            switch (choice){
                case "1":
                    manager.listTasks();
                    break;
                case "2":
                    System.out.print("Введите описание задачи: ");
                    String desc = scanner.nextLine();
                    System.out.print("Введите дату дедлайна (ГГГГ-ММ-ДД): ");
                    String dateStr = scanner.nextLine();
                    try {
                        LocalDate date = LocalDate.parse(dateStr);
                        manager.addTask(new Task(desc, date));
                        System.out.println("Задача добавлена.");
                    } catch (Exception e) {
                        System.out.println("Неверный формат даты.");
                    }
                    break;
                case "3":
                    System.out.print("Введите номер задачи: ");
                    int doneNum = Integer.parseInt(scanner.nextLine());
                    manager.markTaskCompleted(doneNum);
                    break;
                case "4":
                    System.out.print("Введите номер задачи для удаления: ");
                    int removeNum = Integer.parseInt(scanner.nextLine());
                    manager.removeTask(removeNum);
                    break;
                case "5":
                    manager.saveTasksToFile("tasks.txt");
                    break;
                case "6":
                    manager.saveTasksToFile("tasks.txt");
                    System.out.println("Выход. Задачи сохранены.");
                    return;
                default:
                    System.out.println("Неверный выбор. Повторите.");
            }
            System.out.println();
        }
    }
}
