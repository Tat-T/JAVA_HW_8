package org.example.library;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Library library = new Library();

        // Добавляем книги
        library.addBook(new Book("Война и мир", "Лев Толстой"));
        library.addBook(new Book("Преступление и наказание", "Фёдор Достоевский"));
        library.addBook(new Book("Мастер и Маргарита", "Михаил Булгаков"));

        System.out.println("Добро пожаловать в библиотеку!");

        while (true) {
            System.out.println("\n1. Список доступных книг\n2. Взять книгу\n3. Вернуть книгу\n4. Выход");
            System.out.print("Выберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // очистка буфера

            try {
                switch (choice) {
                    case 1 -> {
                        System.out.println("Доступные книги:");
                        for (Book book : library.listAvailableBooks()) {
                            System.out.printf("- %s (%s)\n", book.getTitle(), book.getAuthor());
                        }
                    }
                    case 2 -> {
                        System.out.print("Введите название книги: ");
                        String title = scanner.nextLine();
                        Book book = library.findBookByTitle(title);
                        book.borrow();
                        System.out.println("Книга взята!");
                    }
                    case 3 -> {
                        System.out.print("Введите название книги: ");
                        String title = scanner.nextLine();
                        Book book = library.findBookByTitle(title);
                        book.returnBook();
                        System.out.println("Книга возвращена!");
                    }
                    case 4 -> {
                        System.out.println("До свидания!");
                        System.exit(0);
                    }
                    default -> System.out.println("Неверный выбор!");
                }
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println("Ошибка: " + e.getMessage());
            }
        }
    }
}

